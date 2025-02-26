package bjs2_61466;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class User {
    @Getter
    private final String name;
    private House house = null;
    private Optional<Role> assignedRole = Optional.empty();

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) throws InterruptedException {
        assignedRole = Optional.of(house.assignRole());
        this.house = house;
        log.info("Пользователю {} назначена роль {}", name, assignedRole.get());
    }

    public synchronized void leaveHouse() {
        if (assignedRole.isPresent() && house != null) {
            log.info("Пользователь {} покидает дом. Роль {} возвращается", name, assignedRole.get());
            house.releaseRole(assignedRole.get());
        }

        assignedRole = Optional.empty();
        house = null;
    }
}
