package school.faang.Mnogopotochka.ParallelismThread.BJS2_35893;

import java.util.ArrayList;
import java.util.List;

public class Army {
    public List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> calculators = new ArrayList<>();

        units.forEach(unit -> {
            PowerCalculator calculator = new PowerCalculator(unit);
            calculators.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        });

        return calculators.stream()
                .mapToInt(PowerCalculator::getPower)
                .sum();
    }
}

