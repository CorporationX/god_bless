package school.faang.task4208;

import java.util.concurrent.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

final class Location {
    private final double latitude;
    private final double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}

class Vehicle {
    private final String id;
    private String status;
    private Location location;

    public Vehicle(String id, String status, Location location) {
        this.id = id;
        this.status = status;
        this.location = location;
    }

    public synchronized void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public synchronized void updateLocation(Location newLocation) {
        this.location = newLocation;
    }

    public synchronized String getStatus() {
        return status;
    }

    public synchronized Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}

class TransportManagementSystem {
    private final ConcurrentHashMap<String, Vehicle> vehicles = new ConcurrentHashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    public void updateVehicleLocation(String vehicleId, Location newLocation) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle != null) {
            vehicle.updateLocation(newLocation);
        }
    }

    public Vehicle getVehicleInfo(String vehicleId) {
        return vehicles.get(vehicleId);
    }

    public ConcurrentHashMap<String, Vehicle> getVehicles() {
        return vehicles;
    }
}

class VehicleTracker {
    private final TransportManagementSystem transportManagementSystem;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public VehicleTracker(TransportManagementSystem transportManagementSystem) {
        this.transportManagementSystem = transportManagementSystem;
    }

    public void startTracking() {
        scheduler.scheduleAtFixedRate(() -> {
            for (Vehicle vehicle : transportManagementSystem.getVehicles().values()) {
                double newLatitude = vehicle.getLocation().getLatitude() + (new Random().nextDouble() - 0.5);
                double newLongitude = vehicle.getLocation().getLongitude() + (new Random().nextDouble() - 0.5);
                transportManagementSystem.updateVehicleLocation(vehicle.getId(), new Location(newLatitude, newLongitude));
                System.out.println("Обновлено местоположение ТС " + vehicle.getId() + ": " + newLatitude + ", " + newLongitude);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    public void stopTracking() {
        scheduler.shutdown();
    }
}

public class Main {
    public static void main(String[] args) {
        TransportManagementSystem transportManagementSystem = new TransportManagementSystem();

        Vehicle vehicle1 = new Vehicle("V1", "свободен", new Location(55.7558, 37.6176));
        Vehicle vehicle2 = new Vehicle("V2", "занят", new Location(48.8566, 2.3522));
        Vehicle vehicle3 = new Vehicle("V3", "свободен", new Location(40.7128, -74.0060));

        transportManagementSystem.addVehicle(vehicle1);
        transportManagementSystem.addVehicle(vehicle2);
        transportManagementSystem.addVehicle(vehicle3);

        VehicleTracker vehicleTracker = new VehicleTracker(transportManagementSystem);
        vehicleTracker.startTracking();

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(() -> {
            try {
                Thread.sleep(10000);
                vehicleTracker.stopTracking();
                System.out.println("Завершение работы системы отслеживания");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.shutdown();
        try {
            executor.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
