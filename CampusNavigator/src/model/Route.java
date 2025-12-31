package model;

import java.util.*;

public class Route {
    private List<Location> sequence;
    private double totalDistance;
    private double totalTime;
    private List<String> directions;

    public Route(List<Location> sequence, double totalDistance, double totalTime, List<String> directions) {
        this.sequence = sequence;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.directions = directions;
    }

    public List<Location> getSequence() { return sequence; }
    public double getTotalDistance() { return totalDistance; }
    public double getTotalTime() { return totalTime; }
    public List<String> getDirections() { return directions; }
}