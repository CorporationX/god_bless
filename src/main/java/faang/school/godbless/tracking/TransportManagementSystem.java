package faang.school.godbless.tracking;

import lombok.NonNull;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransportManagementSystem {
    private final ConcurrentHashMap<Location, CopyOnWriteArrayList<Vehicle>> transportLocations = new ConcurrentHashMap<>();

    public void updateVehicleOnLocationMap(@NonNull Location location, @NonNull Vehicle vehicle) {
        Location oldLocation = vehicle.getLocation();
        transportLocations.get(oldLocation).remove(vehicle);
        addVehicleOnLocationMap(location, vehicle);
        vehicle.setLocation(location);
    }

    public void addVehicleOnLocationMap(@NonNull Location location, @NonNull Vehicle vehicle) {
        if (transportLocations.containsKey(location)) {
            transportLocations.get(location).add(vehicle);
        } else {
            CopyOnWriteArrayList<Vehicle> newList = new CopyOnWriteArrayList<>();
            newList.add(vehicle);
            transportLocations.put(location, newList);
        }
        vehicle.setLocation(location);
    }

    public void printVehicleLocationInfo() {
        System.out.println("Location information:");
        transportLocations.entrySet().forEach(System.out::println);
    }
}
