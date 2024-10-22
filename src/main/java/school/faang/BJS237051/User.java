package school.faang.BJS237051;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House newHouse) {
        synchronized (newHouse) {
            try {
                while (newHouse.getAvailableRoleCount() < 1) {
                    System.out.println(name + " подожди пока найдут для тебя подходящую роль!");
                    newHouse.wait();
                }
                house = newHouse;
                role = newHouse.addRole();
                System.out.println(name + " занимает роль " + role);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " отрекается от дома и роли " + role);
            house.removeRole(role);
            house.notifyAll();
            house = new House();
            role = "";
        }
    }
}
