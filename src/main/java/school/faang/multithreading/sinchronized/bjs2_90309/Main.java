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

        List<Runnable> joinHouse = List.of(
                () -> knight.joinHouse(firstHouse, Role.KNIGHT),
                () -> knight2.joinHouse(firstHouse, Role.KNIGHT),
                () -> mag.joinHouse(firstHouse, Role.MAGE),
                () -> mag2.joinHouse(firstHouse, Role.MAGE),
                () -> lord.joinHouse(firstHouse, Role.LORD),
                () -> lord2.joinHouse(firstHouse, Role.LORD)
        );
        List<Runnable> leaveHouse = List.of(
                () -> knight.leaveHouse(),
                () -> knight2.leaveHouse(),
                () -> mag.leaveHouse(),
                () -> mag2.leaveHouse(),
                () -> lord.leaveHouse(),
                () -> lord2.leaveHouse()
        );

        Thread[] threads = new Thread[3];
        for (int i = 0; i < joinHouse.size(); i++) {
            for (int j = 0; j < 3; i++) {
                threads[j] = new Thread(joinHouse.get(i));
                threads[j].start();
                try {
                    Thread.sleep(2000); //имитация нахождения в доме
                } catch (InterruptedException e) {
                    System.err.println("Ошибка в потоке: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    threads[j] = new Thread(leaveHouse.get(i)); // возможно ли это вызвать в текущем потоке?
                    threads[j].start();
                }
            }
        }
    }
}
