package school.faang.sprint3.BJS2_61144;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Army {
    private final Set<Squad<?>> squads = new HashSet<>();
    private ExecutorService executor;
    private final AtomicLong totalStrength = new AtomicLong();

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }

    public long calculateTotalPower() {
        if (squads.isEmpty()) {
            return 0;
        }
        executor = Executors.newFixedThreadPool(squads.size());
        squads.forEach(squad -> executor.submit(() -> calculateSquadPower(squad)));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }

        return totalStrength.get();
    }

    private synchronized void calculateSquadPower(Squad<?> squad) {
        totalStrength.addAndGet(squad.calculateSquadPower());
    }

}
