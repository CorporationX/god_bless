package school.faang.sprint.third.army;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(@NonNull Squad squad) {
        this.squads.add(squad);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Squad squad : squads) {
            executorService.submit(() -> {
                totalPower.addAndGet(squad.calculateSquadPower());
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return totalPower.get();
    }
}
