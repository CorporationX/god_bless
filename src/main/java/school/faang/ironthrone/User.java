package school.faang.ironthrone;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class User {
    private String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            log.info("Пользователь {} присоединился к дому {}", name, house.getName());
        }

    }

    public User(String name) {
        this.name = name;
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                house.releaseRole(assignedRole);
                System.out.println("Пользователь " + name + " покинул дом" + house.getName());
                house = null;
                assignedRole = null;
            }
        }
    }
}
