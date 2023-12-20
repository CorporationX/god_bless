package faang.school.godbless.multi.task8iron_tron;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private String role;

    public void joinHouse() {
        synchronized(house) {
            while (house.getCountRole() == 0) {
                try {
                    house.wait();
                    System.out.println(name + " ожидает...");
                } catch (InterruptedException e) {
                    System.out.println("Игра прервана!");
                    // Возможно, стоит добавить здесь обработку прерывания
                }
            }
            house.addRole(role);
            System.out.println(name + " выбрал роль " + role);
        }
    }

    public synchronized void leaveHouse() {
        house.removeRole(role);
        System.out.println(name + " освободил роль " + role);
    }

    public synchronized void play() {
        try {
            joinHouse();
            System.out.println(name + " играет...");
            Thread.sleep(1000);
            leaveHouse();
        } catch (InterruptedException e) {
            System.out.println("Игра прервана");
        }
    }
}
