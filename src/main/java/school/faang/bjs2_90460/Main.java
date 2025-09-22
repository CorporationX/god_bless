package school.faang.bjs2_90460;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 2;
    private static final int AWAIT_MINUTES = 1;
    private static final int THREAD_SLEEP_MILS = 1000;

    public static void main(String[] args) {
        House whiteHome = new House();
        whiteHome.addRole("cook");
        whiteHome.addRole("cleaner");
        whiteHome.addRole("gardener");
        List<User> users = List.of(
                new User("John"),
                new User("Gregory"),
                new User("Mikhail"),
                new User("Jack"),
                new User("Emma"),
                new User("Sophia"),
                new User("William"),
                new User("Olivia"),
                new User("James"),
                new User("Isabella")
        );
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (User user : users) {
            executor.submit(() -> user.joinHouse(whiteHome));
            try {
                Thread.sleep(THREAD_SLEEP_MILS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Ошибка при имитации работы");
            }
            executor.submit(() -> user.leaveHouse(whiteHome, user));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Потоки не закончили работу за {} - минут. Останавливаем потоки",
                        AWAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при ожидании потоков.");
            executor.shutdownNow();
        }
    }
}
