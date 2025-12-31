package model;

public class Path {
    private Location from;
    private Location to;
    private double distanceMeters;
    private double timeMinutes;
    private boolean accessible;

    public Path(Location from, Location to, double distanceMeters, double timeMinutes, boolean accessible) {
        this.from = from;
        this.to = to;
        this.distanceMeters = distanceMeters;
        this.timeMinutes = timeMinutes;
        this.accessible = accessible;
    }

    public Location getFrom() { return from; }
    public Location getTo() { return to; }
    public double getDistanceMeters() { return distanceMeters; }
    public double getTimeMinutes() { return timeMinutes; }
    public boolean isAccessible() { return accessible; }
}