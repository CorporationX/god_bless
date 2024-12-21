package derschrank.sprint03.task02.bjstwo_47918;

import derschrank.sprint03.task02.bjstwo_47918.units.Unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army implements ArmyInterface {
    private final List<Unit> army;
    private Map<String, Integer> resultOfPowerByTypeOfUnit;

    public Army() {
        this.army = new ArrayList<>();
    }

    @Override
    public void calculateTotalPower() {

        int totalResult = sumPowerOfEveryoneUnitByTypeOfHeroAndGetTotal(
            calculatePowerOfEveryoneUnitInThreads()
        );

        printPowerByTypeOfUnit();
        System.out.println("In total: " + totalResult);
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    private List<CalculatorThread> calculatePowerOfEveryoneUnitInThreads() {
        List<CalculatorThread> threads = new ArrayList<>();

        CalculatorThread thread;
        for (Unit unit : army) {
            thread = new CalculatorThread(unit);
            threads.add(thread);
            thread.start();
        }

        return threads;
    }

    private int sumPowerOfEveryoneUnitByTypeOfHeroAndGetTotal(List<CalculatorThread> threads) {
        resultOfPowerByTypeOfUnit = new HashMap<>();
        int totalResult = 0;
        for (CalculatorThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("CalculatorThread Error: " + e);
            }

            int resultForThisUnit = thread.getCalculatedPowerOfThisUnit();
            resultOfPowerByTypeOfUnit.merge(thread.getTypeOfUnit(),
                    resultForThisUnit,
                    Integer::sum);

            totalResult += resultForThisUnit;
        }

        return totalResult;
    }

    private void printPowerByTypeOfUnit() {
        System.out.println("Power be type of Units:");
        for (String type : resultOfPowerByTypeOfUnit.keySet()) {
            System.out.printf("[%s] : %d%n", type, resultOfPowerByTypeOfUnit.get(type));
        }
    }
}
