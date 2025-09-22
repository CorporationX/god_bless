package school.faang.multithreading.sinchronized.bjs2_90309;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        House firstHouse = new House("Первый дом");

        User knight = new User("первый рыцарь");
        User knight2 = new User("Tom");
        User mag = new User("прирожденный маг");
        User mag2 = new User("маг2");
        User lord = new User("Lord");
        User lord2 = new User("Лорд");

        Thread t1 = new Thread(() -> {
            try {
                knight2.joinHouse(firstHouse, Role.KNIGHT);
                Thread.sleep(2000); // Имитация времени в доме
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Завершаем работу потока
            } finally {
                knight2.leaveHouse(); // Убедимся, что освобождение роли выполнится
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                knight.joinHouse(firstHouse, Role.KNIGHT);
                Thread.sleep(2000); // Имитация времени в доме
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Завершаем работу потока
            } finally {
                knight.leaveHouse(); // Убедимся, что освобождение роли выполнится
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                mag.joinHouse(firstHouse, Role.MAGE);
                Thread.sleep(2000); // Имитация времени в доме
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Завершаем работу потока
            } finally {
                mag.leaveHouse(); // Убедимся, что освобождение роли выполнится
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                mag2.joinHouse(firstHouse, Role.MAGE);
                Thread.sleep(2000); // Имитация времени в доме
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Завершаем работу потока
            } finally {
                mag2.leaveHouse(); // Убедимся, что освобождение роли выполнится
            }
        });

        Thread t5 = new Thread(() -> {
            try {
                lord.joinHouse(firstHouse, Role.LORD);
                Thread.sleep(2000); // Имитация времени в доме
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Завершаем работу потока
            } finally {
                lord.leaveHouse(); // Убедимся, что освобождение роли выполнится
            }
        });

        Thread t6 = new Thread(() -> {
            try {
                lord2.joinHouse(firstHouse, Role.LORD);
                Thread.sleep(2000); // Имитация времени в доме
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt(); // Восстанавливаем флаг
                throw new RuntimeException(e); // Завершаем работу потока
            } finally {
                lord2.leaveHouse(); // Убедимся, что освобождение роли выполнится
            }
        });

        for (Thread t : List.of(t1, t2, t3, t4, t5, t6)) {
            t.start();
        }
    }

}
