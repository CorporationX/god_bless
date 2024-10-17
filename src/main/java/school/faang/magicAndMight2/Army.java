package school.faang.magicAndMight2;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final ArrayList<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    @SneakyThrows
    public int calculatePower() {
        int power = 0;
        List<Thread> threads = new ArrayList<>();
        List<UnitCalculator> calculators = new ArrayList<>();

        for (Unit unit : army) {
            UnitCalculator runnable = new UnitCalculator(unit);
            Thread thread = new Thread(runnable);
            thread.start();
            calculators.add(runnable);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        for (UnitCalculator calculator : calculators) {
            power += calculator.getPower();
        }

        return power;
    }
}
