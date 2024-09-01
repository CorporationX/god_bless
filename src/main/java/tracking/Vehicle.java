package tracking;

import lombok.Getter;
import lombok.NonNull;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter(onMethod_ = {@Synchronized})
public class Vehicle {
    private static final AtomicInteger idCount = new AtomicInteger(0);
    private final int id = idCount.getAndIncrement();

    private StatusState status;
    private Location currentLocation;

    public Vehicle(StatusState status, Location currentLocation) {
        this.status = status;
        this.currentLocation = currentLocation;
    }

    public synchronized void setStatus(@NonNull StatusState status) {
        this.status = status;
        log.info("Vehicle #{} status set to {}", id, status);
    }

    public synchronized void setCurrentLocation(@NonNull Location location) {
        this.currentLocation = location;
        log.info("Vehicle #{} new location: {} | {}", id, location.getLatitude(), location.getLongitude());
    }
}
