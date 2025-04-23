package school.faang.bjs272186;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Army {
    private static final long AWAIT_TIMEOUT = 5;
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        if (squad != null) {
            squads.add(squad);
            System.out.printf("Отряд %s был добавлен в ряды армии %n", squad.getSquadName());
        }
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<CompletableFuture<Integer>> futures = squads.stream()
                .map(squad -> CompletableFuture.supplyAsync(squad::calculateSquadPower, executor))
                .toList();
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Отряды не были добавлены для подсчета общей силы");
                executor.shutdownNow();
            } else {
                System.out.println("Все отряды были добавлены");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return futures.stream()
                .mapToInt(CompletableFuture::join)
                .sum();
    }
}
