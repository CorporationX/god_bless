package school.faang.BJS2_72348;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad<?>> squads = new ArrayList<>();

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        int totalArmyPower = 0;
        List<SquadPowerCalculator> threads = new ArrayList<>();
        squads.forEach(squad -> {
            SquadPowerCalculator thread = new SquadPowerCalculator(squad);
            thread.start();
            threads.add(thread);
        });
        for (SquadPowerCalculator thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalArmyPower += thread.getTotalSquadPower();
        };
        return totalArmyPower;
    }
}
