package school.faang.sprint_3.bjs2_35887_distributedArmyHomm;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PowerCalculator implements Runnable {
    private Unit unit;
    private List<Integer> eachUnitPower;

    @Override
    public void run() {
        eachUnitPower.add(unit.getPower());
    }
}