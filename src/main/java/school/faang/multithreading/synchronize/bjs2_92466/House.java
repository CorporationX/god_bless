package school.faang.multithreading.synchronize.bjs2_92466;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private List<String> rolesToAssign;
    private List<String> rolesToReturn = new ArrayList<>();
    private Object lock = new Object();

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
            rolesToReturn.add(assignedRole);
            return assignedRole;
        }
    }

    public void releaseRole(String roleToRelease) {
        synchronized (lock) {
            if (rolesToReturn.remove(roleToRelease)) {
                rolesToAssign.add(roleToRelease);

                lock.notify();
            }
        }
    }
}