package faang.school.godbless.bjs2_24231;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            while (house.hasNoAvailableRoles()) {
                try {
                    log.info(name + " wait");
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }

            this.house = house;
            this.role = house.removeRole();
            log.info(name + " joined house");
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.addRole(role);
            house = null;
            role = null;
            log.info(name + " left house");
        }
    }
}
