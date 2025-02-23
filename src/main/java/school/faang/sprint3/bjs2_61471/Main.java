package school.faang.sprint3.bjs2_61471;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_NUM = 5;
    private static final int TIME_IN_THE_HOUSE_MS = 2000;
    private static final int AWAIT_TERMINATION_SEC = 5;

    public static void main(String[] args) {
        House house = new House();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        User[] users = {
                new User("John"),
                new User("Deineris"),
                new User("Cersei"),
                new User("Robert"),
                new User("Tirion"),
                new User("Brandon"),
                new User("Drogo"),
                new User("Geoffrey"),
                new User("Tywin")
        };
        Arrays.stream(users).forEach(user -> executorService.submit(() -> {
            user.joinHouse(house);
            try {
                Thread.sleep(TIME_IN_THE_HOUSE_MS);
            } catch (InterruptedException e) {
                log.error(String.format("[%s] [%d] Поток прерван во время сна: %s.%n",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId(),
                        e.getMessage()));
                Thread.currentThread().interrupt();
            } finally {
                user.leaveHouse(house);
            }
        }));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_SEC, TimeUnit.SECONDS)) {
                log.warn(String.format("[%s] [%d] Поток не был остановлен. Завершаем принудительно.%n",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId()));
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(String.format("[%s] [%d] Поток прерван во время остановки: %s.%n",
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    Thread.currentThread().getId(),
                    e.getMessage()));
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
