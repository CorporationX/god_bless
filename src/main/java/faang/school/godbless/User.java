package faang.school.godbless;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) throws InterruptedException {
        this.house = house;

        synchronized (house) {
            while (!house.isRoleAvailable(role)) {
                System.out.println(name + " ждет освобождения роли " + role + " в доме " + house.getName());
                house.wait();
            }
            if (house.addRole(role)) {
                this.role = role;
                System.out.println(name + " присоединился к " + house.getName() + " в роли " + role);
            }
        }
    }

    public void leaveHouse() {
        if (house != null && role != null) {
            synchronized (house) {
                house.removeRole(role);
                System.out.println(name + " покинул " + house.getName() + " и освободил роль " + role);
                role = null;
                house = null;
            }
        }
    }
}
