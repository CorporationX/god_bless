package faang.school.godbless.gameofthrones;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Data
@Slf4j
public class User {
    private final String name;
    private final House house;
    private Role role;

    public void joinHouse() {
        synchronized (house) {
            if (!house.isHaveEmptySlots()) {
                toWaitFreeRole();
            }

            Optional<Role> optionalRole = house.getPriorityRole();
            optionalRole.ifPresentOrElse(role1 -> {
                house.addRole(role1);
                this.role = role1;
                log.info("{} joined, Role {}", name, role);
            }, this::toWaitFreeRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(this.role);
            log.info("{} leave, Role {}", name, role);
        }
        role = null;
    }

    private void toWaitFreeRole() {
        try {
            house.wait();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
