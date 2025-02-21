package school.faang.bjs2_61124;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squads = new ArrayList<>();
    private final AtomicInteger totalPower = new AtomicInteger(0);

    public void addPower(int power) {
        totalPower.addAndGet(power);
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<SquadPowerCalculator> threads = new ArrayList<>();

        for (Squad squad : squads) {
            SquadPowerCalculator thread = new SquadPowerCalculator(this, squad);
            threads.add(thread);
            thread.start();
        }

        for (SquadPowerCalculator thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted while calculating total power.");
                return totalPower.get();
            }
        }
        return totalPower.get();
    }
}
