package faang.school.godbless.tracking;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class VehicleTracker {
    private final TransportManagementSystem system;
    private final ScheduledExecutorService service;

    public VehicleTracker(TransportManagementSystem system) {
        this.system = system;

        service = Executors.newScheduledThreadPool(20);
    }

    public void startUpdating() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ArrayList<Vehicle> vehicles = new ArrayList<>(system.getInfo().values());

        service.scheduleAtFixedRate(() -> {
                    CompletableFuture<Void> future = null;
                    for (Vehicle vehicle : vehicles) {
                        future = CompletableFuture.runAsync(
                                () -> vehicle.setLocation(
                                        new Location(vehicle.getLocation().latitude()
                                                + random.nextInt(-100, 100),
                                        vehicle.getLocation().longitude()
                                                + random.nextInt(-100, 100))),
                                service);
                    }
                    assert future != null;
                    future.thenRun(system::update);
                },
                1_000,
                2_000,
                TimeUnit.MILLISECONDS
        );
    }

    public void stopUpdating() {
        service.shutdown();
        try {
            if (service.awaitTermination(3_000, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
