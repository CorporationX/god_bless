package faang.school.godbless.multithreading.distributedheroes;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {

    private final List<Unit> armyUnits = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyUnits.add(unit);
    }

    public int calculateTotalPower() {
        List<UnitPowerCalculator> unitPowerCalculators =
                armyUnits.stream()
                        .map(UnitPowerCalculator::new)
                        .peek(UnitPowerCalculator::start)
                        .toList();

        return unitPowerCalculators.stream()
                .peek(upc -> {
                    try {
                        upc.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(UnitPowerCalculator::getPower)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
