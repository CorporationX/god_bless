package school.faang.BJS2_61080.army;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor

public class Army {
    private final List<Squad> squads;

    public void calculateTotalPower() throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(squads.size());
        CountDownLatch latch = new CountDownLatch(squads.size());
        AtomicInteger totalPower = new AtomicInteger(0);


        squads.forEach(squad -> {
            Objects.requireNonNull(squad, "Squad can't be null");
            executor.submit(() -> {
                totalPower.addAndGet(squad.calculateSquadPower());
                latch.countDown();
            });
        });

        latch.await();
        executor.shutdown();

        System.out.printf("Обчие количество силы у армий :%d", totalPower.get());
    }
}
