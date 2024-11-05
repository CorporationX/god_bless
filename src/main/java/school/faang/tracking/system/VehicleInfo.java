package school.faang.tracking.system;

public record VehicleInfo(String id, Status status, Location location) {

    @Override
    public String toString() {
        return id + " " + status + " " + location;
    }
}
