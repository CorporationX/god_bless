package school.faang.multithreading.sinchronized.bjs2_90309;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private String name;
    private Role assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Role role) {
        synchronized (house) {
            assignedRole = role;
            this.house = house;
            house.assignRole(role);
            log.info("{} присоединяется к дому '{}' с ролью '{}'", name, house.getName(), assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                log.info("{} покидает дом и освобождает роль '{}'", name, assignedRole);
                house.releaseRole(assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
