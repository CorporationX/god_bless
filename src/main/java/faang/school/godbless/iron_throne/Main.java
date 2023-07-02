package faang.school.godbless.iron_throne;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        House starkHouse = new House("Stark");
        starkHouse.getRoles().add("Knight");
        starkHouse.getRoles().add("Lord");
        starkHouse.getRoles().add("Maester");
        starkHouse.getRoles().add("Сook");
        starkHouse.getRoles().add("Hunky");

        List<User> users = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            users.add(new User("User-" + i));
        }

        Thread thread1 = new Thread(() -> {
            users.get(0).joinHouse(starkHouse, "Knight");
            users.get(1).joinHouse(starkHouse, "Knight");
            users.get(2).joinHouse(starkHouse, "Lord");
            users.get(3).joinHouse(starkHouse, "Maester");
            users.get(4).joinHouse(starkHouse, "Сook");
            users.get(5).joinHouse(starkHouse, "Hunky");
            users.get(7).joinHouse(starkHouse, "Knight");

        });

        Thread thread2 = new Thread(() -> {
            users.get(4).leaveHouse(starkHouse);
            users.get(0).leaveHouse(starkHouse);
            users.get(6).joinHouse(starkHouse, "Hunky");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
