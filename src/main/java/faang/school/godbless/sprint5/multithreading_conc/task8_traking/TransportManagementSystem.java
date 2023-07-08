package faang.school.godbless.sprint5.multithreading_conc.task8_traking;

import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {

    private ConcurrentHashMap<Integer, Vehicle> vehicles;

    public TransportManagementSystem() {
        this.vehicles = new ConcurrentHashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        System.out.println("Vehicle №" + vehicle.getId() + " location is " + vehicle.getLocation() + " added");
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void removeVehicle(int id) {
        System.out.println("Vehicle №" + id + " removed");
        vehicles.remove(id);
    }

    public Status getVehicleStatus(int id) {
        return vehicles.get(id).getStatus();
    }

    private Location getVehicleLocation(int id) {
        return vehicles.get(id).getLocation();
    }

    public void updateVehicleStatus(int id, Status status) {
        System.out.println("Vehicle №" + id + " status is " + status + " updated");
        vehicles.get(id).setStatus(status);
    }

    public void updateVehicleLocation(int id) {
        vehicles.get(id).setLocation(
                vehicles.get(id).getLocation().getNewLocation());
    }
}
