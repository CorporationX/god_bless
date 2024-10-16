package school.faang.sprint_3.bjs2_35887_distributedArmyHomm;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army = new ArrayList<>();

    public int calculateTotalPower() {
        List<Integer> unitsPower = new ArrayList<>();

        for (Unit unit : army) {
            Thread thread = new Thread(new PowerCalculator(unit, unitsPower));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return unitsPower.stream()
                .mapToInt(i -> i)
                .sum();
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }
}
