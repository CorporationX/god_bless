package faang.school.godbless.BJS2_25365;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Getter
public class TransportManagementSystem {
    private final Map<Integer, Vehicle> cars = new ConcurrentHashMap();

    public List<Vehicle> getVehicles(){
        return cars.values().stream().toList();
    }

    public void addVehicle(Vehicle vehicle){
        log.info("Vehicle {} (id {}) was added to track system", vehicle, vehicle.getId());
        cars.put(vehicle.getId(), vehicle);
    }

    public Vehicle getHeicle(int id){
        log.info("Getting vehicle with {}", id);
        return cars.get(id);
    }

    public void updateStatus(int id, STATUS status){
        cars.get(id).setStatus(status);
        log.info("Vehicle with id {} updated. Now status is {}", id, cars.get(id).getStatus());
    }
}
