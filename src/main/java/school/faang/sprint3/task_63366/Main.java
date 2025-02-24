package school.faang.sprint3.task_63366;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {
    private static final int COUNT_THREADS = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(COUNT_THREADS);
    private static final int COUNT_USERS = 50;
    private static final String logInfo = "Принудительно закрываем пул потоков";

    public static void main(String[] args) {
        House house = new House();

        IntStream.range(0, COUNT_USERS)
                .mapToObj(num -> new User("User_" + num))
                .forEach(user -> EXECUTOR.submit(() -> user.joinHouse(house)));

        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(COUNT_USERS * User.TIME_ON_DUTY, TimeUnit.MILLISECONDS)) {
                log.info(logInfo);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("{} с исключением", logInfo, e);
            EXECUTOR.shutdownNow();
        }
        User.printResult();
    }
}
