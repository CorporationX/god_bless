package school.faang.task_61521;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            log.info(name + " выбрал роль: " + assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                log.info(name + " покидает дом и освобождает роль: " + assignedRole);
                house.releaseRole(assignedRole); // Освобождаем роль
                assignedRole = null; // Сбрасываем роль
                house = null; // Сбрасываем дом
            }
        }
    }
}
