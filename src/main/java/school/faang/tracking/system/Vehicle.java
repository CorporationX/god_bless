package school.faang.tracking.system;

import lombok.Getter;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
public class Vehicle {
    private final String id;
    private volatile Status status;
    private volatile Location location;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public Vehicle(String id, Location location) {
        this.id = id;
        this.location = location;
        status = Status.FREE;
    }

    public void updateStatus(Status newStatus) {
        rwLock.writeLock().lock();
        try {
            status = newStatus;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void updateLocation(Location newLocation) {
        rwLock.writeLock().lock();
        try {
            location = newLocation;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public VehicleInfo getVehicleInfo() {
        rwLock.readLock().lock();
        try {
            return new VehicleInfo(id, status, location);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
