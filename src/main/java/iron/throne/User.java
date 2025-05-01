package iron.throne;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class User {
    private String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            while (house.getRoles().isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.house = house;
            assignedRole = house.assignRole();
            log.info("User {} assigned role {}", name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (this) {
            house.releaseRole(assignedRole);
            this.notify();
            log.info("User {} leaved role {}", name, assignedRole);
            assignedRole = null;
            house = null;
        }
    }
}
