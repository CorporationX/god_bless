package school.faang.task48825;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class User {
    private final String name;
    private final Role role;
    private final House house;

    public synchronized void joinHouse() {
        synchronized (house) {
            house.addRole(role);
            log.info("Игрок {} присоединяется к дому {} в роли: {}", name, house.getNameHouse(), role.name());
        }
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            log.info("Игрок {} покидает дом {}", name, house.getNameHouse());
        }
    }
}
