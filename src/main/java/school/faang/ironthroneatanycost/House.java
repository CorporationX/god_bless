package school.faang.ironthroneatanycost;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class House {
    private final String name;
    private final Map<String, Integer> availableRoles = new ConcurrentHashMap<>();
    private final Lock lock = new ReentrantLock();

    public House(String name, Map<String, Integer> initialRoles) {
        this.name = name;
        this.availableRoles.putAll(initialRoles);
    }

    public boolean addRole(String role) {
        lock.lock();
        try {
            if (availableRoles.getOrDefault(role, 0) > 0) {
                availableRoles.put(role, availableRoles.get(role) - 1);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void removeRole(String role) {
        lock.lock();
        try {
            availableRoles.put(role, availableRoles.getOrDefault(role, 0) + 1);
            synchronized (this) {
                notifyAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
