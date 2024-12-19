package school.faang.sprint_3.task_47907;

import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

public class Army {
    private int totalPower = 0;
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        List<PowerCalculator> powerCalculators = new ArrayList<>();
        for (Unit unit : units) {
            PowerCalculator calculatePower = new PowerCalculator(unit);
            powerCalculators.add(calculatePower);
            calculatePower.start();
        }

        for (PowerCalculator powerCalculator : powerCalculators) {
            powerCalculator.join();
            totalPower += powerCalculator.getPower();
        }
        return totalPower;
    }
}
