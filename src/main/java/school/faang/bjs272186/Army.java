package school.faang.bjs272186;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Army {
    private static final long AWAIT_TIMEOUT = 5;
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
        System.out.printf("Отряд %s был добавлен в ряды армии %n", squad.getSquadName());
    }

    public int calculateTotalPower() {
        List<Integer> calculatorResult = new ArrayList<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (Squad squad : squads) {
            try {
                calculatorResult.add(executor.submit(squad::calculateSquadPower).get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
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

        return calculatorResult.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
