package gameOfThrones;

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
            log.info("{} получил(а) роль: {}.", name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                house.releaseRole(assignedRole);
                log.info("{} покинул(а) дом, освободил роль: {}.", name, assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
