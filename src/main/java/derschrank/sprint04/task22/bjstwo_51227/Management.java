package derschrank.sprint04.task22.bjstwo_51227;

import derschrank.sprint04.task22.bjstwo_51227.units.Location;
import derschrank.sprint04.task22.bjstwo_51227.units.Status;
import derschrank.sprint04.task22.bjstwo_51227.units.Vehicle;

import java.util.Optional;

public interface Management {
    void addVehicle(Vehicle vehicle);

    void updateVehicleLocation(String vehicleId, Location newLocation);

    void updateVehicleStatus(String vehicleId, Status newStatus);

    Location getVehicleLocation(String vehicleId);

    Status getVehicleStatus(String vehicleId);

    String getVehicleInfo(String vehicleId);

    boolean isThereVehicle(String vehicleId);
}
