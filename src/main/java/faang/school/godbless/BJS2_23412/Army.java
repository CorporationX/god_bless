package faang.school.godbless.BJS2_23412;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<PowerCalculator> powerCalculators = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator powerCalculator = new PowerCalculator(unit);
            powerCalculators.add(powerCalculator);
            powerCalculator.start();
        }

        int totalPower = 0;
        for (PowerCalculator powerCalculator : powerCalculators) {
            try {
                powerCalculator.join();
                totalPower += powerCalculator.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPower;
    }
}
