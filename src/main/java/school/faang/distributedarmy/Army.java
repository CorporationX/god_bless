package school.faang.distributedarmy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final Logger log = LoggerFactory.getLogger(Army.class);
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
                log.error("Caught exception: ", e);
                e.printStackTrace();
                throw new IllegalStateException("Thread was interrupted while waiting for calculator to finish.");
            }
            resultPower += calculator.getTotalPower();
        }
        return resultPower;
    }
}
