package faang.school.godbless.armyOfHeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Creature> army = new ArrayList<>();
    private int totalPower = 0;

    public int calculateTotalPower() {
        List<SquadCalculate> threads = new ArrayList<>();
//        army.forEach((creature)->{
//            SquadCalculate thread = new SquadCalculate(creature);
//            threads.add(thread);
//            thread.start();
//        });
//        threads.forEach((thread)->{
//            totalPower += thread.getSquadPower();
//        });
        for (Creature creature : army) {
            SquadCalculate squadCalculate = new SquadCalculate(creature);
            threads.add(squadCalculate);
            squadCalculate.start();
        }
        for (SquadCalculate thread : threads) {
            totalPower += thread.getSquadPower();
        }
        return totalPower;
    }

    public void addUnit(Creature creature) {
        army.add(creature);
    }
}

