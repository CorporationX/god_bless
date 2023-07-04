package faang.school.godbless.Sprint_4.Multithreading_Parallelism.DistributedArmyOfHMM;

import lombok.Getter;

@Getter
public class CalculatorOfPower extends Thread {
    private Unit unit;
    private int unitPower;

    public CalculatorOfPower(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
