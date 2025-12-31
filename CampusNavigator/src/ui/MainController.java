package ui;

import algo.Dijkstra;
import data.SampleData;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

import java.util.Optional;

public class MainController {
    @FXML private ComboBox<Location> startBox;
    @FXML private ComboBox<Location> goalBox;
    @FXML private ComboBox<String> facingBox;
    @FXML private TextArea outputArea;

    private CampusMap map;

    @FXML
    public void initialize() {
        map = SampleData.buildMap();
        startBox.getItems().addAll(map.getLocations());
        goalBox.getItems().addAll(map.getLocations());
        facingBox.getItems().addAll("North", "East", "South", "West");
    }

    @FXML
    public void findRoute() {
        Location start = startBox.getValue();
        Location goal = goalBox.getValue();
        String facing = facingBox.getValue();

        double userAngle = switch (facing) {
            case "North" -> Math.PI/2;
            case "East" -> 0;
            case "South" -> -Math.PI/2;
            case "West" -> Math.PI;
            default -> 0;
        };

        Optional<Route> route = Dijkstra.shortestPath(map, start, goal, false, Dijkstra.Metric.DISTANCE, userAngle);

        if (route.isPresent()) {
            Route r = route.get();
            outputArea.setText("Route: " + r.getSequence() +
                "\nDistance: " + r.getTotalDistance() + " m" +
                "\nTime: " + r.getTotalTime() + " min" +
                "\nDirections:\n" + String.join("\n", r.getDirections()));
        } else {
            outputArea.setText("No route found.");
        }
    }
}