package school.faang.bjs2_81166;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad<?>> squads = new ArrayList<>();

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerCalculatorThread> threads = new ArrayList<>();

        for (Squad<?> squad : squads) {
            SquadPowerCalculatorThread thread = new SquadPowerCalculatorThread(squad);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;
        for (SquadPowerCalculatorThread thread : threads) {
            thread.join();
            totalPower += thread.getTotalPower();
        }

        return totalPower;
    }
}
