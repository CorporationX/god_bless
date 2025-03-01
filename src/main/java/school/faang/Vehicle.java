package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
public class Vehicle {
    private final int id;
    private Status status;
    private Location location;
    private final ReentrantLock lock = new ReentrantLock();

    public void updateStatus(Status newStatus) {
        lock.lock();
        try {
            status = newStatus;
        } finally {
            lock.unlock();
        }
    }

    public void updateLocation(Location newLocation) {
        lock.lock();
        try {
            location = newLocation;
        } finally {
            lock.unlock();
        }
    }
}
