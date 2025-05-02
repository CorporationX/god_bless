package school.faang.ironthrone;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private final String name;
    private String assignedRole;
    private House house;
    private final Object lock = new Object();

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (lock) {
            this.house = house;
            this.assignedRole = house.assignRole();
            log.info("\n{} занял роль: {}", name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            if (house != null && assignedRole != null) {
                house.releaseRole(assignedRole);
                log.info("\n{} освободил роль: {}", name, assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
