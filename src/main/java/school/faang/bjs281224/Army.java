package school.faang.bjs281224;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Squad> squads = new ArrayList<>();

    public Army addSquad(Squad squad) {
        squads.add(squad);
        return this;
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadCalculator> threads = new ArrayList<>();

        for (Squad squad : squads) {
            SquadCalculator thread = new SquadCalculator(squad);
            thread.start();
            threads.add(thread);
        }

        int total = 0;

        for (SquadCalculator thread : threads) {
            thread.join();
            total += thread.getResult();
        }

        return total;
    }
}