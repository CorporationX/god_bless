package school.faang.ironthrone;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class House {
    private final List<String> availableRoles;

    public House(List<String> availableRoles) {
        this.availableRoles = availableRoles;
    }

    public void assignRole(String role) throws InterruptedException {
        synchronized (availableRoles) {
            while (!availableRoles.contains(role)) {
                availableRoles.wait();
                log.info("Ожидание роли - {}", role);

            }
            availableRoles.remove(role);
        }
    }

    public void releaseRole(String role) {
        synchronized (availableRoles) {
            availableRoles.add(role);
            availableRoles.notifyAll();
        }
    }
}
