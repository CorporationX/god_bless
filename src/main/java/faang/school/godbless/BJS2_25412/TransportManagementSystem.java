package faang.school.godbless.BJS2_25412;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.ConcurrentHashMap;

@ToString
@Getter
public class TransportManagementSystem {
    ConcurrentHashMap<Integer, Vehicle> transports = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        transports.putIfAbsent(vehicle.getId(), vehicle);
    }

    public Vehicle getVehicle(int id) {
        return transports.get(id);
    }
}
