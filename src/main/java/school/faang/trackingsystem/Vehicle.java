package school.faang.trackingsystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Vehicle {
    private final UUID id = UUID.randomUUID();
    private final String name;
    private final Object lockVehicle = new Object();

    private volatile Statuses status = Statuses.BUSY;
    private volatile Location location = new Location();

    public void updateStatus(Statuses status) {
        synchronized (lockVehicle) {
            validateStatus(status);
            this.status = status;
        }
    }

    public void updateLocation(Location location) {
        synchronized (lockVehicle) {
            this.location = location;
            checkIfVehicleOnBase();
        }
    }

    private void validateStatus(Statuses status) {
        Objects.requireNonNull(status, "Invalid status value");
    }

    private void checkIfVehicleOnBase() {
        if (getLocation().isWithinBase() && getStatus().equals(Statuses.BUSY)) {
            updateStatus(Statuses.FREE);
            log.info("Vehicle {} is arrived on base", getName());
        } else if (getLocation().isOutsideBase() && getStatus().equals(Statuses.FREE)) {
            updateStatus(Statuses.BUSY);
            log.info("Vehicle {} is leaved from base", getName());
        }
    }
}
