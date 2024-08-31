package faang.school.godbless.TrackingSystem;

import com.sun.jdi.connect.Transport;
import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    @Getter
    private ConcurrentHashMap<Integer, Vehicle> transportsById = new ConcurrentHashMap<>();

    public void addTransport(Vehicle vehicle) {
        transportsById.put(vehicle.getId(), vehicle);
    }

    public Vehicle getTransportById(int id) {
        return transportsById.get(id);
    }

    public synchronized void printTransports() {
        transportsById.forEach((id, vehicle) -> System.out.println(id + ": " + vehicle.getLocation().getLatitude() + " " + vehicle.getLocation().getLongitude()));
    }
}
