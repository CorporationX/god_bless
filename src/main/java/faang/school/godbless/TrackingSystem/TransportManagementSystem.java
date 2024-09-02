package faang.school.godbless.TrackingSystem;

import lombok.Getter;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class TransportManagementSystem {
    private ConcurrentHashMap<Integer, Vehicle> transportsById;

    public TransportManagementSystem() {
        transportsById = new ConcurrentHashMap<>();
    }

    public void addTransport(Vehicle vehicle) {
        transportsById.put(vehicle.getId(), vehicle);
    }

    public Vehicle getTransportById(int id) {
        return transportsById.get(id);
    }

    public void printTransports() {
        transportsById.forEach((id, vehicle) -> System.out.println(id + ": " + vehicle.getLocation().getLatitude() + " " + vehicle.getLocation().getLongitude()));
    }

    public void updateTransportLocation(int id, int newLatitude, int newLongitude) {
        transportsById.get(id).setLocation(new Location(newLatitude, newLongitude));
    }

}
