package faang.school.godbless.DistributedArmy;

import lombok.Getter;

@Getter
public class UnitPowerCalculator extends Thread{
    private ArmyUnit division;
    private int unitsAmount;
    private int divisionPower;

    public UnitPowerCalculator(ArmyUnit unit, int unitsAmount) {
        this.division = unit;
        this.unitsAmount = unitsAmount;
    }

    @Override
    public void run() {
        divisionPower = division.getPower() * unitsAmount;
    }
}


