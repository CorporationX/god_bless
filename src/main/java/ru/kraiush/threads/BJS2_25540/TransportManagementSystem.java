package ru.kraiush.threads.BJS2_25540;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@AllArgsConstructor
public class TransportManagementSystem implements Runnable {

    List<Vehicle> listVehicles = new ArrayList<>();

    public TransportManagementSystem(List<Vehicle> listVehicles) {
        this.listVehicles = listVehicles;
    }

    private ConcurrentHashMap<Location, Vehicle> mapVehicles = new ConcurrentHashMap<>();

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long end = start + 20 * 1000;
        while (System.currentTimeMillis() < end) {
            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(750, 1000));
                moveOver_a_Little(listVehicles);
                changeStatus(listVehicles);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(String.join("", Collections.nCopies(125, "-")));
        System.out.println("\nThe final map");
        mapVehicles.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));
        System.out.print(String.join("", Collections.nCopies(125, "-")));
    }

    public void add(List<Vehicle> listVehicles) {
        int latitude = ThreadLocalRandom.current().nextInt(1, 1000);
        int longititude = ThreadLocalRandom.current().nextInt(1, 1000);
        Location location = new Location(latitude, longititude);
        listVehicles.add(new Vehicle(listVehicles.size(), true, location));
        mapVehicles.put(location, listVehicles.get(listVehicles.size() - 1));
//        mapVehicles.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));
    }

    public Vehicle motion(Vehicle vehicle) {
        int latitude = vehicle.getLocation().getLatitude() + ThreadLocalRandom.current().nextInt(1, 50);
        int longititude = vehicle.getLocation().getLongitude() + ThreadLocalRandom.current().nextInt(1, 50);
        vehicle.setLocation(new Location(latitude, longititude));
        mapVehicles.put(getKey(vehicle), vehicle);
        System.out.println("The vehicle is coming!");
        System.out.println(vehicle);
        return vehicle;
    }

    private Location getKey(Vehicle vehicle) {
        Stream<Location> keyStream = mapVehicles.entrySet()
                .stream()
                .filter(entry -> vehicle.equals(entry.getValue()))
                .map(Map.Entry::getKey);
        return keyStream.findFirst().get();
    }

    private void moveOver_a_Little(List<Vehicle> listVehicles) {
        int index = ThreadLocalRandom.current().nextInt(0, listVehicles.size());
        Vehicle vehicle = listVehicles.get(index);
        motion(vehicle);
        mapVehicles.put(getKey(vehicle), vehicle);
    }

    private void changeStatus(List<Vehicle> listVehicles) {
        int index = ThreadLocalRandom.current().nextInt(0, listVehicles.size());
        Vehicle vehicle = listVehicles.get(index);
        vehicle.setStatus(!vehicle.isStatus());
        System.out.println("Changed status!");
        System.out.println(vehicle);
        mapVehicles.put(getKey(vehicle), vehicle);
    }
}
