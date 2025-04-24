package src.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class BigBangTheory {
    private static final int POOL_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        final Random random = new Random();
        final ExecutorService executor = Executors.newFixedThreadPool(POOL_COUNT);
        final CountDownLatch countDownLatch = new CountDownLatch(POOL_COUNT);
        final List<Task> tasks = List.of(
                new Task("Шелдон", "Помыть полы", random, countDownLatch),
                new Task("Леонард", "Съесть торт", random, countDownLatch),
                new Task("Говард", "Изучить квантовую физику", random, countDownLatch),
                new Task("Раджеш", "Сходить помыться", random, countDownLatch)
        );

        for (final Task task : tasks) {
            executor.execute(task);
        }

        countDownLatch.await();
        log.info("\nВсе задачи выполнены");
        executor.shutdown();
    }
}

