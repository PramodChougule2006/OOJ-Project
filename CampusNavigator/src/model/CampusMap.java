package model;

import java.util.*;

public class CampusMap {
    private Map<Location, List<Path>> adj = new HashMap<>();

    public void addUndirectedPath(Location a, Location b, double dist, double time, boolean accessible) {
        Path ab = new Path(a, b, dist, time, accessible);
        Path ba = new Path(b, a, dist, time, accessible);
        adj.computeIfAbsent(a, k -> new ArrayList<>()).add(ab);
        adj.computeIfAbsent(b, k -> new ArrayList<>()).add(ba);
    }

    public List<Location> getLocations() {
        return new ArrayList<>(adj.keySet());
    }

    public List<Path> getNeighbors(Location l) {
        return adj.getOrDefault(l, Collections.emptyList());
    }
}