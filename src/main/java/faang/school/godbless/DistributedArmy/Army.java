package faang.school.godbless.DistributedArmy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Army {
    private Map<ArmyUnit, Integer> armyDivisions = new HashMap<>();

    public void addUnit(ArmyUnit unit) {
        armyDivisions.merge(unit, 1, Integer::sum);
    }

    public int calculateTotalPower() {
        int totalArmyPower = 0;
        List<UnitPowerCalculator> calculators = new ArrayList<>();

        for (Map.Entry<ArmyUnit, Integer> division: armyDivisions.entrySet()) {
            UnitPowerCalculator calculator = new UnitPowerCalculator(division.getKey(), division.getValue());
            calculators.add(calculator);
            calculator.start();
        }

        for (UnitPowerCalculator calculator : calculators) {
            try {
                calculator.join();
                totalArmyPower += calculator.getDivisionPower();
                System.out.println("Total power of " + calculator.getDivision() + " division is: " + calculator.getDivisionPower());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return totalArmyPower;
    }

}
