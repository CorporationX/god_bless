package school.faang.BJS2_61537;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> roles = List.of("Лорд", "Рыцарь", "Маг");
        House house = new House(roles);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            User user = new User("User " + i);
            Thread thread = new Thread(() -> {
                try {
                    user.joinHouse(house);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    user.leaveHouse();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все пользователь освободили роли!");
    }
}
