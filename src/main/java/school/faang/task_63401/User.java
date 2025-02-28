package school.faang.task_63401;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class User {
    private final String name;
    private String assignedRole;
    private final House house;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() {
        assignedRole = house.assignRole();
        log.info("{} выбрал роль: {}", name, assignedRole);
    }

    public void leaveHouse() {
        if (assignedRole != null) {
            log.info("{} покидает дом и освобождает роль: {}", name, assignedRole);
            house.releaseRole(assignedRole);
            assignedRole = null;
        }
    }
}
