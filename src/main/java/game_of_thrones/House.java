package game_of_thrones;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class House {
    private final Set<String> availableRoles;
    private final Lock lock = new ReentrantLock();
    private final Condition roleAvailable = lock.newCondition();

    public House(List<String> availableRoles) {
        this.availableRoles = new HashSet<>(availableRoles);
    }

    public void addRole(String role) {
        lock.lock();
        try {
            availableRoles.add(role);
            System.out.println("Роль '" + role + "' освободилась. Доступные роли: " + availableRoles);
            roleAvailable.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void removeRole(String role) {
        lock.lock();
        try {
            if (availableRoles.contains(role)) {
                availableRoles.remove(role);
                System.out.println("Роль '" + role + "' занята. Доступные роли: " + availableRoles);
                roleAvailable.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getRoleAvailableCondition() {
        return roleAvailable;
    }

    public Set<String> getAvailableRoles() {
        return new HashSet<>(availableRoles);
    }
}