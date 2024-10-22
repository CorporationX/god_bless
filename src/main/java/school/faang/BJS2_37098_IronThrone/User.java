package school.faang.BJS2_37098_IronThrone;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private String name;

    @Setter
    private House house;

    @Setter
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
            house.addRole(this);
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
