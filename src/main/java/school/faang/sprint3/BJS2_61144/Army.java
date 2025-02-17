package school.faang.sprint3.BJS2_61144;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {
    private final Set<Squad<?>> squads = new HashSet<>();
    private ExecutorService executor;
    private volatile long totalStrength;

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }

    public long calculateTotalPower() {
        executor = Executors.newFixedThreadPool(squads.size());
        squads.forEach(squad -> executor.submit(() -> calculateSquadPower(squad)));

        executor.shutdown();
        sleep();
        return totalStrength;
    }

    private synchronized void calculateSquadPower(Squad<?> squad) {
        totalStrength += squad.calculateSquadPower();
    }

    private void sleep() {
        try {
            Thread.sleep(31);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
