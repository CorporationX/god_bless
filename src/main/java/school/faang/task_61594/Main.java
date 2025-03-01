package school.faang.task_61594;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        House house = new House(new ArrayList<>(
                List.of("Маг", "Рыцарь", "Варвар", "Лорд")), "Дом#12");
        User[] users = {
                new User("Олег"),
                new User("Марк"),
                new User("Костя"),
                new User("Соня")
        };

        List<Thread> threads = new ArrayList<>();

        for (User user : users) {
            Thread thread = new Thread(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Ошибка в потоке: " + e);
                    Thread.currentThread().interrupt();
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
                System.out.printf("%s поток был прерван! Ошибка: %s%n",
                        thread, e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        System.out.println("Программа завершилась!");
    }
}
