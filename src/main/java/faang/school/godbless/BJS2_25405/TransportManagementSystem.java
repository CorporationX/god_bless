package faang.school.godbless.BJS2_25405;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TransportManagementSystem {
    private Map<Integer, Vehicle> vehicles = new HashMap<>();

    public void putVehicle(Integer key, Vehicle value) {
        vehicles.put(key, value);
    }

    public int getCountVehicles() {
        return vehicles.size();
    }

    public void forEachValues(Consumer<Vehicle> action) {
        vehicles.values().forEach(action);
    }
}
