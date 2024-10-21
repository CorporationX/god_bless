package school.faang.ironthroneatanycost;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class House {
    private final String name;
    private final Map<String, Integer> availableRoles;
    private final Lock lock = new ReentrantLock();

    public House(String name, Map<String, Integer> availableRoles) {
        this.name = name;
        this.availableRoles = new ConcurrentHashMap<>(availableRoles);
    }
}
