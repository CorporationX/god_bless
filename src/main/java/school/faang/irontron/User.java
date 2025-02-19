package school.faang.irontron;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class User {
    private final String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name + Thread.currentThread().getName();
    }

    public synchronized void joinHouse(House house, Role role) {
        try {
            if (house.assignRole(this, role)) {
                log.info("Пользователь {} успешно вступил в дом {}  на роль {}", name, house.getName(), role);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn(e.getMessage());
        }
    }

    public synchronized void leaveHouse() {
        if (house.releaseRole(this.role)) {
            log.info("{} вышел из дома {}", name, house.getName());
            house = null;
            role = null;
        }
    }

}
