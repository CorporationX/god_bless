package school.faang.task_61398;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        Objects.requireNonNull(squad, "Squad cant be null");
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerCalculator> threads = new ArrayList<>();

        for (Squad squad : squads) {
            SquadPowerCalculator thread = new SquadPowerCalculator(squad);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;
        for (SquadPowerCalculator thread : threads) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }
}
