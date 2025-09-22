package school.faang.module3.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<ArmyCalculator> calculators = new ArrayList<>();

        squads.forEach(s -> {
            ArmyCalculator calculator = new ArmyCalculator(s);
            calculators.add(calculator);
            calculator.start();
        });

        return calculators.stream()
                .peek(c -> {
                    try {
                        c.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                })
                .mapToInt(ArmyCalculator::getTotalPower)
                .sum();
    }
}
