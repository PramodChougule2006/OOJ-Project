package model;


public class Location {
    private String id;
    private String name;
    private double x, y; // coordinates on map

    public Location(String id, String name, double x, double y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public String toString() { return name; }
}
