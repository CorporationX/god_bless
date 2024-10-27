package faang.school.godbless.mt.got;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) throws InterruptedException {
        if (house != null) {
            leaveHouse();
        }

        this.role = house.addRole();
        this.house = house;
        log.info("{} присоединился к роли '{}' в доме '{}'", name, role, house.getName());
    }

    public synchronized void leaveHouse() {
        if (house == null) return;

        house.removeRole();
        log.info("{} покинул роль '{}' в доме '{}'", name, role, house.getName());
        this.house = null;
        this.role = null;
    }
}
