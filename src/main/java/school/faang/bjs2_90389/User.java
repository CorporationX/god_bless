package school.faang.bjs2_90389;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class User {

    private final String name;
    private Roles assignedRole;

    public void joinHouse(House house, Roles role) {
        house.assignRole(role);
        this.assignedRole = role;
        log.info("User {} joined house with role {}", name, role);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.warn("{} has been interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }

    public void leaveHouse(House house) {
        if (assignedRole != null) {
            house.releaseRole(assignedRole);
            log.info("User {} left the house and release role {}", name, assignedRole);
            assignedRole = null;
        }
    }
}
