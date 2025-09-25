package school.faang.iron.throne.at.any.cost;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (this) {
            this.assignedRole = house.assignRole();
            this.house = house;
            log.info("{} выбрал роль {}", name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (this) {
            if (house != null && assignedRole != null) {
                log.info("{} покидает дом и освобождает роль: {}", name, assignedRole);
                house.releaseRole(assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
