package school.faang.mice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);

        if (house.checkCollectedFood()) {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                    log.info("Потоки принудительно прерваны по истечению времени");
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            } finally {
                log.info("Основной поток закрыт");
            }
        }
    }
}