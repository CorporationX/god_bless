package school.faang.BJS2_60708;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

@AllArgsConstructor
public class WeasleyFamily {
    private final List<Chore> chores;

    public void actionsCore() throws InterruptedException {
        Objects.requireNonNull(chores, "List<Chore> can't be null");

        CountDownLatch latch = new CountDownLatch(chores.size());
        try (ExecutorService executor = newCachedThreadPool()) {
            chores.forEach((chore -> {
                Objects.requireNonNull(chore, "Chore can't be null");
                executor.execute(() -> {
                    chore.run();
                    latch.countDown();
                });
            }));

            latch.await();
        }

        System.out.println("Все домашние дела семьи Уизли выполнены");
    }
}
