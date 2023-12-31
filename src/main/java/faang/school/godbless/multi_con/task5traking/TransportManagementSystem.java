package faang.school.godbless.multi_con.task5traking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private final Map<Integer, Vehicle> vehicles= new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicle(int id, String status, double diffLatitude, double diffLongitude) {
        Vehicle vehicle = vehicles.get(id);
        if (vehicle != null) {
            double latitude = vehicle.getLocation().getLatitude();
            double longitude = vehicle.getLocation().getLongitude();
            vehicle.setStatus(status);
            vehicle.setLocation(new Location(latitude + diffLatitude, longitude + diffLongitude));
        }
    }

    public Vehicle getVehicle(Integer id) {
        return vehicles.get(id);
    }

    public Map<Integer, Vehicle> getVehicles() {
        return vehicles;
    }
}
