package school.faang.bjs2_61124;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();
    private int totalPower = 0;

    public synchronized void addPower(int power) {
        totalPower += power;
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerCalculator> threads = new ArrayList<>();

        for (Squad squad : squads) {
            SquadPowerCalculator thread = new SquadPowerCalculator(this, squad);
            threads.add(thread);
            thread.start();
        }

        for (SquadPowerCalculator thread : threads) {
            thread.join();
        }
        return totalPower;
    }
}
