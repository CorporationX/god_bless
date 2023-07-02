package faang.school.godbless.Sprint3.Task_11_GoogleMaps;

public class Location {
    private String name;
    private double latitude;
    private double longitude;

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
