package school.faang.ironthroneatanycost;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class App {
    private static final int THREE_SECONDS = 3000;
    private static final List<User> USERS = new ArrayList<>(Arrays.asList(
            new User("Арья"),
            new User("Дейнерис"),
            new User("Тирион"),
            new User("Джон")
    ));

    public static void main(String[] args) {
        House house = new House();
        List<Thread> threads = new ArrayList<>();

        for (User user : USERS) {
            Thread thread = new Thread(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(THREE_SECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток пользователя {} прерван: {}",
                            user.getName(), e.getMessage());
                }
                user.leaveHouse();
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Главный поток прерван {}", e.getMessage());
            }
        }

        log.info("Все пользователи покинули дом. Завершаем работу приложения.");
    }
}
