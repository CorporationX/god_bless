package school.faang.got;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class User {

    @Getter
    @Setter
    private String name;
    private House house;
    @Getter
    @Setter
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        Objects.requireNonNull(house, "House cannot be null");
        log.info("{} join house {}", name, house.getName());
        this.house = house;
        synchronized (house) {
            if (!house.areRolesAvailable()) {
                log.info("{} waiting for role", name);
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    log.error("Exception was caught", e);
                    throw new IllegalStateException(
                            String.format("Thread %s interrupted", Thread.currentThread().getName()), e
                    );
                }
            }
            house.addRole(this);
            log.info("{} got role {}", name, role);
        }
    }

    public void leaveHouse() {
        if (house == null) {
            log.info("{} has no house", name);
            return;
        }
        synchronized (house) {
            house.removeRole(this);
            log.info("{} left house {}", name, house.getName());
            house.notify();
        }
        house = null;
    }
}
