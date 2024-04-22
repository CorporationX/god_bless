package faang.school.godbless.armyOfHeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Creature> army = new ArrayList<>();

    public int calculateTotalPower() {
        int totalPower = 0;
        for (Creature creature : army) {
            SquadCalculate squadCalculate = new SquadCalculate(creature);
            squadCalculate.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += squadCalculate.getSquadPower();
        }
        return totalPower;
    }

    public void addUnit(Creature creature) {
        army.add(creature);
    }
}

