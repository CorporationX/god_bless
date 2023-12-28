package faang.school.godbless.multi.task8iron_tron;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House houseParam, String roleParam) {
        house = houseParam;
        role = roleParam;
        synchronized (house) {
            while (house.getCountRole() == 0) {
                try {
                    System.out.println(name + " ожидает...");
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println("Игра прервана!");
                }
            }
            this.role = role;
            house.removeRole(role);
            System.out.println(name + " выбрал роль " + role);
        }
    }

    public synchronized void leaveHouse() {
        house.addRole(role);
        System.out.println(name + " освободил роль " + role);
        role = null;;
    }
}
