package derschrank.sprint04.task22.bjstwo_51227.units;

import lombok.Getter;

@Getter
public class Vehicle {
    private static final Status DEFAULT_STATUS = Status.FREE;
    private static final Location DEFAULT_LOCATION = new Location(0, 0);


    private final String id;
    private volatile Status status;
    private volatile Location location;

    public Vehicle(String id) {
        this.id = id;
        status = DEFAULT_STATUS;
        location = DEFAULT_LOCATION;
    }

    public void updateStatus(Status newStatus) {
        logUpdate("Status", status, newStatus);
        status = newStatus;
    }

    public void updateLocation(Location newLocation) {
        logUpdate("Location", location, newLocation);
        location = newLocation;
    }

    private void logUpdate(String type, Object oldValue, Object newValue) {
        System.out.printf("Vehicle: %s. %s was updated. Old: %s, new: %s%n",
                id, type, oldValue, newValue);
    }

    @Override
    public String toString() {
        return String.format("Vehicle: %s, Status: %s, Location: %s", id, status, location);
    }
}
