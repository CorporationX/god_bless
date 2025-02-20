package school.faang.BJS2_61080.army;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class ArmyThread {
    private final List<Army> armies;

    public void totalArmiesCount() throws InterruptedException {
        Objects.requireNonNull(armies, "List<Army> can't be null");
        ExecutorService executor = Executors.newFixedThreadPool(armies.size());
        CountDownLatch latch = new CountDownLatch(armies.size());


        armies.forEach(army -> {
            executor.submit(() -> {
                try {
                    army.calculateTotalPower();
                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("Ошибка при подсчете силы армии.", e);
                }
            });
        });

        latch.await();
        executor.shutdown();
        System.out.println("⚔️ Битва завершена! Обе армии подсчитали силу.");
    }
}
