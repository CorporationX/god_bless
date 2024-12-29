package school.faang.sprint3.bjs_48809;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private final String name;
    private House joinedHouse;
    private Role chosenRole;
    private final Object lockHouse = new Object();

    public User(String name) {
        this.name = name;
        this.joinedHouse = null;
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (lockHouse) {
            while (house.getFreeRolesCount() == 0) {
                try {
                    log.info("{} waiting for available roles", name);
                    lockHouse.wait();
                } catch (InterruptedException e) {
                    log.warn("No available roles");
                }
            }
            chosenRole = house.getRole();
            joinedHouse = house;
            log.info("{} chose the role {}", name, chosenRole);
        }
    }

    public void leaveHouse() {
        if (joinedHouse == null) {
            log.warn("You are not joined to this house");
        } else {
            synchronized (lockHouse) {
                joinedHouse.returnRole(chosenRole);
                lockHouse.notifyAll();
            }
            chosenRole = null;
            joinedHouse = null;
            log.info("{} leave the house", name);
        }
    }
}
