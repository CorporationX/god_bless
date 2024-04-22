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
                toWait();
            }

            Optional<Role> optionalRole = house.getPriorityRole();
            if (optionalRole.isEmpty()) {
                toWait();
            } else {
                house.addRole(optionalRole.get());
                this.role = optionalRole.get();
                System.out.println(getName() + " joined, Role " + role);
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(this.role);
            System.out.println(getName() + " leave, Role " + role);
        }
        role = null;
    }

    private void toWait() {
        try {
            house.wait();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
