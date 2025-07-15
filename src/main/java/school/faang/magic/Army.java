package school.faang.magic;

import java.util.ArrayList;
import java.util.List;

class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerCalculator> calculators = new ArrayList<>();

        for (Squad squad : squads) {
            SquadPowerCalculator calculator = new SquadPowerCalculator(squad);
            calculators.add(calculator);
            calculator.start();
        }

        int totalPower = 0;

        for (SquadPowerCalculator calculator : calculators) {
            calculator.join();
            totalPower += calculator.getSquadPower();
        }

        return totalPower;
    }
}