package school.faang.bjs2_90319;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private House house;
    private String name;
    private String assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            log.info("{} выбрал роль: {}", name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                log.info("{} покидает дом и освобождает роль: {}", name, assignedRole);
                house.releaseRole(assignedRole);
                house = null;
            }
        }
    }
}
