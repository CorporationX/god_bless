package faang.school.godbless.throne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private String role;

    public synchronized void joinHouse(House house) {
        while (house.getNumAvailableRoles() >= 5) {
            try {
                System.out.println("Все роли заняты в " + house + " | Ожидание...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!house.getAvailableRoles().contains(role)) {
            this.house = house;
            house.addRole(role);
            System.out.println(name + " присоединился к " + house + " в роли " + role);
        } else {
            System.out.println("Роль " + role + " уже занята");
        }
    }

    public synchronized void leaveHouse(House house) {
        if (house.getAvailableRoles().contains(role)) {
            house.removeRole(role);
            System.out.println(name + " покинул роль " + role);
        } else {
            System.out.println("Такой роли нет в доме");
        }
    }
}
