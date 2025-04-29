package school.faang.homm;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Squad> units = new ArrayList<>();

    public void addSquad(Squad squad) {
        units.add(squad);
    }

    public int calculateTotalPower() {
        SquadPowerCalculator[] threads = new SquadPowerCalculator[units.size()];
        for (int i = 0; i < units.size(); i++) {
            threads[i] = new SquadPowerCalculator(units.get(i));
            threads[i].start();
        }
        int totalPower = 0;
        try {
            for (SquadPowerCalculator calculator : threads) {
                calculator.join();
                totalPower += calculator.getSquadPowerResult();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return totalPower;
    }
}
