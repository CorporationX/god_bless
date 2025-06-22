package school.faang.bjs2_81972;

import lombok.extern.slf4j.Slf4j;

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
            assignedRole = house.assignRole();
            this.house = house;
            log.info(name + " выбрал роль: " + assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                log.info("{} покидает дом и освобождает роль: {}", name, assignedRole);
                house.releaseRole(assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
