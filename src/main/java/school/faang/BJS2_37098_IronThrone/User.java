package school.faang.BJS2_37098_IronThrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        leaveHouse();
        synchronized (house) {
            while (!house.isHasAvailableRoles()) {
                try {
                    log.info("User {} is waiting for an available role in the house {}", name, house.getName());
                    house.wait();
                } catch (InterruptedException e) {
                    log.error(
                            "Thread {} of user {} was interrupted while waiting for an available role in the house {}.",
                            Thread.currentThread().getName(), name, house.getName(),
                            e
                    );
                }
            }
            role = house.addRole(this);
            this.house = house;
        }
    }

    public void leaveHouse() {
        if (house != null) {
            synchronized (house) {
                house.removeRole(this);
                log.info("User {} left the house {}, notifying others...", name, house.getName());
                house.notify();
            }
            house = null;
            role = null;
        }
    }
}
