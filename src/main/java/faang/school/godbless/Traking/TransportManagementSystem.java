package faang.school.godbless.Traking;

import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
public class TransportManagementSystem {
    private final ConcurrentHashMap<String, Vehicle> vehicles = new ConcurrentHashMap<>();
    private final int moving = Math.toIntExact(Math.round(Math.random() * 10));

    public synchronized void addVehicle(Vehicle vehicle) {
        if (!vehicles.containsKey(vehicle.getId())) {
            vehicles.put(vehicle.getId(), vehicle);
            System.out.println("Vehicle Added : " + vehicle.getId());
        }
    }

    public synchronized void updateVehicleLocation(Vehicle vehicle) {
        vehicles.get(vehicle.getId()).updateLocation(vehicle.getLocation().getLatitude() + moving, vehicle.getLocation().getLongitude() + moving);
        System.out.println(vehicle.getId() + " Vehicle Location : " + vehicles.get(vehicle.getId()).getLocation());
        //System.out.println(vehicle.getId() + " Vehicle Status : " + vehicle.getStatus());
    }

    public synchronized void updateVehicleStatus(Vehicle vehicle) {
        vehicles.get(vehicle.getId()).updateStatus();
        System.out.println(vehicles.get(vehicle.getId()).getId() + " Vehicle Status : " + vehicles.get(vehicle.getId()).getStatus());
    }

    public synchronized void getVehicleInformation(Vehicle vehicle) {
        System.out.println(vehicles.get(vehicle.getId()));
    }
}
