package school.faang.tracking.system;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_OF_USER = 10;

    public static void main(String[] args) {
        TransportManagementSystem system = new TransportManagementSystem();
        Vehicle bus = new Vehicle("bus", Location.generateRandomLocation());
        Vehicle car = new Vehicle("car", Location.generateRandomLocation());
        Vehicle truck = new Vehicle("truck", Location.generateRandomLocation());
        Vehicle train = new Vehicle("train", Location.generateRandomLocation());

        system.addVehicle(bus);
        system.addVehicle(car);
        system.addVehicle(truck);
        system.addVehicle(train);

        List<CompletableFuture<VehicleInfo>> completableFutures = IntStream.range(0, NUM_OF_USER)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                            VehicleInfo info = system.getVehicleInfo(bus.getId());
                            System.out.println(info);
                            return info;
                        }
                ))
                .toList();

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
                .thenRun(VehicleTracker::shutDown);
    }
}
