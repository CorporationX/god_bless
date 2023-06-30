package faang.school.godbless.kxnvg.ironthrone;

import lombok.Getter;

import java.util.Random;

@Getter
public class User {

    private String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House desiredHouse) {
        house = desiredHouse;
        if (house.getFreeRoles() == 0) {
            try {
                System.out.println(name + " ожидает свободной роли в доме " + house.getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int value = house.getFreeRoles();
        role = house.getRoles().get(new Random().nextInt(value));
        house.removeRole(role);
        System.out.println(name + " выбирает роль " + role + " в доме " + house.getName());
    }

    public synchronized void leaveHouse() {
        if (role != null) {
            System.out.println(name + " покидает дом " + house.getName() + " и освобождает свою роль " + role);
            house.addRole(role);
            house = null;
            role = null;
            notifyAll();
        }
    }
}
