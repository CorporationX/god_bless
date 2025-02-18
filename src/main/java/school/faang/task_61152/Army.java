package school.faang.task_61152;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<PowerCalculator> threads = new ArrayList<>();
        int totalPower = 0;

        for (Squad squad : squads) {
            PowerCalculator thread = new PowerCalculator(squad);
            threads.add(thread);
            thread.start();
        }

        for (PowerCalculator thread : threads) {
            thread.join();
            totalPower += thread.getPower();
        }

        return totalPower;
    }

    public void addSquad(Squad squad) {
        this.squads.add(squad);
    }
}
