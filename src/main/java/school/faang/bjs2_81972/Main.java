package school.faang.bjs2_81972;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House starkHouse = new House(new ArrayList<>(List.of("Воин", "Шпион", "Дипломат")));
        List<User> users = List.of(
                new User("John"),
                new User("Area"),
                new User("Sansa"),
                new User("Reckon"),
                new User("Bran"),
                new User("Robb")
        );
        List<Thread> threads = new ArrayList<>();

        for (User user : users) {
            Thread thread = new Thread(() -> {
                try {
                    user.joinHouse(starkHouse);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("Ошибка в потоке: {}", e.getMessage());
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
                log.error("Ошибка в ожидании завершения потоке: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        log.info("Все потоки завершены.");
    }
}
