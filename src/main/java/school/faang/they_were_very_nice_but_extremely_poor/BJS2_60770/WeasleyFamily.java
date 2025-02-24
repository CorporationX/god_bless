package school.faang.they_were_very_nice_but_extremely_poor.BJS2_60770;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeasleyFamily.class);

    private final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final CountDownLatch countDownLatch = new CountDownLatch(chores.length);

    public void doHouseholdChores() {
        for (String chore : chores) {
            executorService.submit(() -> {
                new Chore(chore).run();
                countDownLatch.countDown();
            });
        }


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            LOGGER.error("Поток был прерван во время ожидания. {}", e.getMessage());
            Thread.currentThread().interrupt();
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("Все задачи выполнены");
    }
}
