package bjs2_61466;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<Role> availableRoles;

    public House(List<Role> availableRoles) {
        // Нужно создать копию, т.к. входной список может быть readonly
        this.availableRoles = new ArrayList<>(availableRoles);
    }

    public synchronized Role assignRole() {
        while (availableRoles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                final String logMessage = "Поток для дома остановлен";
                log.error(logMessage, e);
                Thread.currentThread().interrupt();

                throw new RuntimeException(logMessage);
            }
        }

        return availableRoles.remove(0);
    }

    public synchronized void releaseRole(Role role) {
        availableRoles.add(role);
        notifyAll();
    }
}
