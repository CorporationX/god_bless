package school.faang.sprint_4.tracking_system;

public class Vehicle {
    private int id;
    private String status;
    private Location location;

    private void updateStatus(String status) {
        this.status = status;
    }

    private void updateLocation(Location location) {
        this.location = location;
    }
}
