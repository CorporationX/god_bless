package faang.model;

import faang.Squad;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(final Squad squad) {
        squads.add(squad);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final AtomicInteger power = new AtomicInteger();
        final CountDownLatch countDownLatch = new CountDownLatch(squads.size());

        for (Squad squad : squads) {
            executorService.execute(() -> {
                int calculatedSquadPower = squad.calculateSquadPower();
                power.addAndGet(calculatedSquadPower);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        return power.get();
    }
}
