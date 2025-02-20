package school.faang.BJS2_60708;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newCachedThreadPool;

@AllArgsConstructor
public class WeasleyFamily {
    private final List<Chore> chores;
    private final Logger logger = LoggerFactory.getLogger(WeasleyFamily.class);

    public void actionsCore() throws InterruptedException {

        Objects.requireNonNull(chores, "List<Chore> can't be null");

        CountDownLatch latch = new CountDownLatch(chores.size());
        ExecutorService executor = newCachedThreadPool();

        try {
            chores.forEach((chore -> {
                Objects.requireNonNull(chore, "Chore can't be null");
                executor.execute(() -> {
                    chore.run();
                    latch.countDown();
                });
            }));

            latch.await();
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                logger.error("Не все потоки завершились вовремя, принудительно завершаем...");
                executor.shutdownNow();
            }
        }

        System.out.println("Все домашние дела семьи Уизли выполнены");
    }
}
