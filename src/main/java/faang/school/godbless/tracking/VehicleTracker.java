package faang.school.godbless.tracking;

import java.util.ArrayList;
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
        service.scheduleAtFixedRate(system::update,
                2_000,
                3_000,
                TimeUnit.MILLISECONDS
        );

        ArrayList<Vehicle> vehicles = new ArrayList<>(system.getInfo().values());

        service.scheduleAtFixedRate(() -> {
                    for (Vehicle vehicle : vehicles) {
                        service.schedule(
                                () -> vehicle.setLocation(new Location(vehicle.getLocation().latitude() + random.nextInt(-100, 100),
                                        vehicle.getLocation().longitude() + random.nextInt(-100, 100))),
                                1_000,
                                TimeUnit.MILLISECONDS
                        );
                    }
                }, 1_000,
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
