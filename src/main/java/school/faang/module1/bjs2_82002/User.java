package school.faang.module1.bjs2_82002;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {

    private final String name;
    private Role assignedRole;
    private House house;

    public void joinHouse(House house) {
        if (house == null) {
            throw new IllegalArgumentException("House не может быть null");
        }
        if (this.house != null) {
            log.warn("Пользователь {} уже находится в доме", name);
            return;
        }
        this.assignedRole = house.assignRole();
        this.house = house;
        log.info("Пользователь {} присоединился к дому с ролью {}", name, assignedRole);
    }

    public void leaveHouse() {
        if (house == null) {
            log.warn("Пользователь {} не состоит ни в одном доме", name);
            return;
        }
        if (assignedRole == null) {
            log.warn("Пользователь {} не имеет роли", name);
            return;
        }
        house.releaseRole(assignedRole);
        log.info("{} покидает дом, освобождает роль {}", name, assignedRole);
        this.assignedRole = null;
        this.house = null;
    }
}