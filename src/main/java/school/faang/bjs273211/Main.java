package school.faang.bjs273211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Role> roles = Arrays.asList(
                Role.ЛОРД,
                Role.РЫЦАРЬ,
                Role.МАГ
        );
        House house1 = new House(roles);

        List<User> users = Arrays.asList(
                new User("Вася"),
                new User("Петя"),
                new User("Нина"),
                new User("Зина")
        );

        List<Thread> threads = new ArrayList<>();

        for (User user : users) {
            Thread thread = new Thread(() -> {
                try {
                    user.joinHouse(house1);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println("Ошибка " + e.getMessage());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    user.leaveHouse();
                }
            }, "Юзер " + user.getName());
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Ошибка " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
