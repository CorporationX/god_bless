package distributedArmyOfHeroesOfMightAndMagic_35930;

import distributedArmyOfHeroesOfMightAndMagic_35930.entity.Unit;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> creatures;
    private int totalPower = 0;

    public Army() {
        creatures = new ArrayList<>();
    }

    public void addUnit(Unit creature) {
        creatures.add(creature);
    }

    public int calculateTotalPower() {
        List<CalculatorPower> threads = new ArrayList<>();

        for (Unit creature : creatures) {
            CalculatorPower thread = new CalculatorPower(creature);
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += thread.getPower();
        });

        return totalPower;
    }
}
