package bjs2_90348;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int SLEEP_MS = 3_000;

    public static void main(String[] args) {
        House starkHouse = new House(Arrays.asList("Лорд", "Рыцарь", "Маг"));
        List<String> names = List.of("Джон", "Арья", "Бран", "Санса", "Тирион");
        List<Thread> threads = names.stream()
                .map(User::new)
                .map(user -> new Thread(() -> simulateUser(user, starkHouse)))
                .toList();

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Ошибка ожидания завершения потоков: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        System.out.println("Все игроки закончили игру.");
    }

    private static void simulateUser(User user, House house) {
        try {
            user.joinHouse(house);
            Thread.sleep(SLEEP_MS);
        } catch (InterruptedException e) {
            System.err.println("Ошибка в потоке " + Thread.currentThread().getName() + ": " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            user.leaveHouse();
        }
    }
}
