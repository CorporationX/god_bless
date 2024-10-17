package school.faang.distributedarmy;

import lombok.Getter;

public class Calculator extends Thread{
    private Unit unit;
    @Getter
    private int totalPower;

    public Calculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        totalPower = unit.getPower();
    }
}
