package school.faang.ironthrone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private  String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            System.out.println("Пользователь " + name + " присоединился к дому " + house.getName());
        }

    }

    public User(String name) {
        this.name = name;
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                house.releaseRole(assignedRole);
                house = null;
                assignedRole = null;
                System.out.println("Пользователь " + name + " покинул дом" + house.getName());
            }
        }
    }
}
