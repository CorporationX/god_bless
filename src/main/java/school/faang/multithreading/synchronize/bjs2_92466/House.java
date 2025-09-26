package school.faang.multithreading.synchronize.bjs2_92466;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class House {
    private List<String> rolesToAssign;
    private final Object lock = new Object();

    public House(List<String> rolesToAssign) {
        this.rolesToAssign = rolesToAssign;
    }

    public String assignRole() {
        synchronized (lock) {
            while (rolesToAssign.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            final String assignedRole = rolesToAssign.remove(0);
            return assignedRole;
        }
    }

    public void releaseRole(String roleToRelease) {
        synchronized (lock) {
            rolesToAssign.add(roleToRelease);
            lock.notify();
        }
    }
}