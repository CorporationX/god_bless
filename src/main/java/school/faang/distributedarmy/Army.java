package school.faang.distributedarmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> fighters = new ArrayList<>();
    private int resultPower = 0;
    private List<Calculator> calculators = new ArrayList<>();

    public void addUnit(Unit unit) {
        fighters.add(unit);
    }

    public int calculateTotalPower() {
        for (Unit unit : fighters) {
            Calculator calculator = new Calculator(unit);
            calculators.add(calculator);
            calculator.start();
        }
        for (Calculator calculator : calculators) {
            try {
                calculator.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            resultPower += calculator.getTotalPower();
        }
        return resultPower;
    }
}
