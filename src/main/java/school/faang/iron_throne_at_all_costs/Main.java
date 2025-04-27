package school.faang.iron_throne_at_all_costs;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        House lannister = new House("Ланнистер",
                List.of("Лорд", "Рыцарь", "Маг", "Шут"));

        User tyrion = new User("Тирион");
        User cersei = new User("Серсея");
        User jaime = new User("Джейме");
        User bronn = new User("Бронн");

        Thread t1 = new Thread(() -> {
            try {
                tyrion.joinHouse(lannister, "Лорд");
                Thread.sleep(2000);
                tyrion.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                cersei.joinHouse(lannister, "Лорд");
                cersei.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                jaime.joinHouse(lannister, "Рыцарь");
                Thread.sleep(1000);
                jaime.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        final Thread t4 = new Thread(() -> {
            try {
                bronn.joinHouse(lannister, "Шут");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
