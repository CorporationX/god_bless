package school.faang.ironthrone;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_NUM = 5;
    private static final int TIME_IN_THE_HOUSE_MS = 2000;
    private static final int AWAIT_TERMINATION = 5;

    public static void main(String[] args) {

        House house = new House();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);
        User[] users = {new User("Толик"),
                new User("Колян"),
                new User("Димон"),
                new User("Виталик")};

        Arrays.stream(users).forEach(user -> executor.submit(() -> {
            user.joinHouse(house);
            try {
                Thread.sleep(TIME_IN_THE_HOUSE_MS);
            } catch (InterruptedException e) {
                log.error("Поток прерван во время сна ", e);
                Thread.currentThread().interrupt();
            } finally {
                user.leaveHouse(house);
            }
        }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.warn("Поток не был остановлен. Принудительно останавливаю...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван во время остановки ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
