package school.faang.sprint_3.heroes;

import lombok.SneakyThrows;
import school.faang.sprint_3.heroes.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Unit> units = new ArrayList<>();

    public void addUnits(Unit unit) {
        units.add(unit);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        int totalPower = 0;
        List<PowerCalculator> powers = new ArrayList<>();

        for (Unit unit : units) {
            PowerCalculator calculator = new PowerCalculator(unit);
            powers.add(calculator);
            calculator.start();
        }

        for (PowerCalculator e : powers) {
            e.join();
            totalPower += e.getPower();
        }

        return totalPower;
    }
}
