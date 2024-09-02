package faang.school.godbless.TheIronThroneAtAnyCost;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@RequiredArgsConstructor
@Slf4j
public class User {
    private final String name;
    private House house;
    private String role;

    public void joinHouse(House house, String role) {
        synchronized (house.getRoles()) {
            while (!house.isAvailableRole(role)) {
                try {
                    log.info("{} waiting for {} in {}", name, role, house.getName());
                    house.getRoles().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Error while waiting: {}", e.getMessage());
                }
            }
            house.addRole(role);
            this.house = house;
            this.role = role;
            log.info("{} joined house {} as {}", name, house.getName(), role);
        }
    }

    public void leaveHouse() {
        synchronized (house.getRoles()) {
            if (house == null || role == null) {
                return;
            }
            house.removeRole(role);
            log.info("{} left house {} and freed the role of {}", name, house.getName(), role);
            this.house = null;
            this.role = null;
        }
    }
}