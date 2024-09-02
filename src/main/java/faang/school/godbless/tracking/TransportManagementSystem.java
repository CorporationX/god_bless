package faang.school.godbless.tracking;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransportManagementSystem {
    private final Map<Location, Vehicle> vehicleMap;

    public TransportManagementSystem(List<Vehicle> vehicles) {
        this.vehicleMap = new ConcurrentHashMap<>();
        vehicles.forEach(this::addVehicle);
    }

    //любые добавление в мапу только через этот метод,
    //потому что в нем есть обработка случая, когда 2 корабля попали в одну точку, а значит никто
    //никого не перетрет
    public void addVehicle(Vehicle vehicle) {
        while (vehicleMap.containsKey(vehicle.getLocation())) {
            vehicle.setLocation(new Location(vehicle.getLocation().latitude() - 1,
                    vehicle.getLocation().longitude()));//если вдруг в одной точке оказались, то один двигается
        }

        vehicleMap.put(vehicle.getLocation(), vehicle);
    }

    public void update() {
        for (Map.Entry<Location, Vehicle> entry : vehicleMap.entrySet()) {
            if (!entry.getValue().getLocation().equals(entry.getKey())) {//если положение изменилось
                addVehicle(vehicleMap.remove(entry.getKey()));
            }
        }
    }

    public Map<Location, Vehicle> getInfo() {
        return vehicleMap;
    }
}
