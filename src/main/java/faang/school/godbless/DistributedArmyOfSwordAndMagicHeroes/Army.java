package faang.school.godbless.DistributedArmyOfSwordAndMagicHeroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {
    private final List<Character> DIVISIONS = new ArrayList<>();

    synchronized int calculateTotalPower() {

        List<PowerCalculator> calculators = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Character character : DIVISIONS) {
            PowerCalculator calculator = new PowerCalculator(character);
            calculators.add(calculator);
            executor.submit(calculator);
        }

        executor.shutdown();

        return calculators.stream()
                .mapToInt(PowerCalculator::getPower)
                .sum();
    }

    public void addUnit(Character character) {
        DIVISIONS.add(character);
    }
}
