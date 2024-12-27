package school.faang.moduleone.sprintthree.task_43556;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    static final int COLLECTORS_COUNT = 5;
    static final int DELAY = 0;
    static final int PERIOD = 5;
    static final int ROOMS_COUNT = 20;
    static final int THREADS_COUNT = 5;
    static final int TIMEOUT = 5;

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(ROOMS_COUNT);
        House house = new House(ROOMS_COUNT, cdl);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(COLLECTORS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            executor.scheduleAtFixedRate(new FoodCollector(house), DELAY, PERIOD, TimeUnit.SECONDS);
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            log.error("Some error with await: {}", e.getMessage());
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.error("Часть потоков не смогли завершить работу. Останавливаем принудительно.");
                executor.shutdownNow();
            }
            log.info("Все потоки корректно завершили работу");
        } catch (InterruptedException e) {
            log.error("Завершение работы потоков было прервано: " + e.getMessage());
            executor.shutdownNow();
        }
        log.info("Вся еда собрана. Работа завершена.");
    }
}
