package algo;

import model.*;
import java.util.*;

public class Dijkstra {
    public enum Metric { DISTANCE, TIME }

    public static Optional<Route> shortestPath(CampusMap map, Location start, Location goal,
                                               boolean requireAccessible, Metric metric, double userAngle) {
        Map<Location, Double> dist = new HashMap<>();
        Map<Location, Location> prev = new HashMap<>();
        PriorityQueue<Location> pq = new PriorityQueue<>(Comparator.comparingDouble(dist::get));

        for (Location l : map.getLocations()) dist.put(l, Double.POSITIVE_INFINITY);
        dist.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Location u = pq.poll();
            if (u.equals(goal)) break;

            for (Path edge : map.getNeighbors(u)) {
                if (requireAccessible && !edge.isAccessible()) continue;

                double weight = (metric == Metric.DISTANCE) ? edge.getDistanceMeters() : edge.getTimeMinutes();
                double alt = dist.get(u) + weight;

                Location v = edge.getTo();
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    pq.remove(v);
                    pq.add(v);
                }
            }
        }

        if (!prev.containsKey(goal) && !start.equals(goal)) return Optional.empty();

        // Reconstruct path
        List<Location> seq = new ArrayList<>();
        Location cur = goal;
        seq.add(cur);
        while (!cur.equals(start)) {
            cur = prev.get(cur);
            if (cur == null) return Optional.empty();
            seq.add(cur);
        }
        Collections.reverse(seq);

        // Compute totals and directions
        double totalDist = 0, totalTime = 0;
        List<String> directions = new ArrayList<>();
        double currentAngle = userAngle;

        for (int i = 0; i < seq.size() - 1; i++) {
            Location a = seq.get(i), b = seq.get(i + 1);
            Path p = map.getNeighbors(a).stream()
                    .filter(e -> e.getTo().equals(b) && (!requireAccessible || e.isAccessible()))
                    .findFirst().orElse(null);
            if (p != null) {
                totalDist += p.getDistanceMeters();
                totalTime += p.getTimeMinutes();
                directions.add(getDirection(a, b, currentAngle));
                currentAngle = Math.atan2(b.getY() - a.getY(), b.getX() - a.getX());
            }
        }

        return Optional.of(new Route(seq, totalDist, totalTime, directions));
    }

    private static String getDirection(Location current, Location next, double userAngle) {
        double dx = next.getX() - current.getX();
        double dy = next.getY() - current.getY();
        double angle = Math.atan2(dy, dx);
        double relative = angle - userAngle;

        if (Math.abs(relative) < Math.PI/4) return "Go straight to " + next.getName();
        else if (relative > 0) return "Turn left towards " + next.getName();
        else if (relative < 0) return "Turn right towards " + next.getName();
        else return "Turn back to " + next.getName();
    }
}