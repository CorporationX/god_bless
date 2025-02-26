package school.faang.throne;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        House ironHouse = new House(new ArrayList<>(Arrays.asList("Lord", "Knight", "Magician")));

        User jon = new User("Jon");
        User rhaegar = new User("Rhaegar");
        User daenerys = new User("Daenerys");

        Thread thread1 = new Thread(() -> {
            try {
                jon.joinHouse(ironHouse);
                Thread.sleep(2000); // Имитация работы
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Прерываем поток
            } finally {
                jon.leaveHouse(); // Освобождаем роль в любом случае
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                rhaegar.joinHouse(ironHouse);
                Thread.sleep(2000); // Имитация работы
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Прерываем поток
            } finally {
                rhaegar.leaveHouse(); // Освобождаем роль в любом случае
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                daenerys.joinHouse(ironHouse);
                Thread.sleep(2000); // Имитация работы
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Прерываем поток
            } finally {
                daenerys.leaveHouse(); // Освобождаем роль в любом случае
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Error waiting for threads to finish: " + e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("All threads are completed.");
    }
}
