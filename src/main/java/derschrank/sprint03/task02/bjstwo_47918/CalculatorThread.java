package derschrank.sprint03.task02.bjstwo_47918;

import derschrank.sprint03.task02.bjstwo_47918.units.Unit;

public class CalculatorThread extends Thread {
    private final Unit unit;
    private Integer resultOfCalculatingThisUnit;

    public CalculatorThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        resultOfCalculatingThisUnit = unit.getPower();
    }

    public int getCalculatedPowerOfThisUnit() {
        return resultOfCalculatingThisUnit;
    }

    public String getTypeOfUnit() {
        return unit.getTypeOfUnit();
    }
}
