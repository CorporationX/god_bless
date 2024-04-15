package faang.school.godbless.hmmarmy;

import faang.school.godbless.hmmarmy.characters.Archer;
import faang.school.godbless.hmmarmy.characters.Mage;
import faang.school.godbless.hmmarmy.characters.Swordsman;
import faang.school.godbless.hmmarmy.characters.Unit;

import java.util.ArrayList;
import java.util.List;


public class Army {

    private int totalPower = 0;
    private List<Unit> army = new ArrayList<>();

    private List<CalculatorThread> threads = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        initializeThreads();

        for (CalculatorThread thread : threads) {
            thread.start();
        }

        for (CalculatorThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += thread.getPower();
        }
        return totalPower;
    }

    private void initializeThreads() {
        for (Unit unit : army) {
            if (unit instanceof Archer) {
                CalculatorThread archerThread = new CalculatorThread(unit);
                threads.add(archerThread);
            } else if (unit instanceof Swordsman) {
                CalculatorThread swordsmanThread = new CalculatorThread(unit);
                threads.add(swordsmanThread);
            } else if (unit instanceof Mage) {
                CalculatorThread mageThread = new CalculatorThread(unit);
                threads.add(mageThread);
            } else {
                CalculatorThread otherThread = new CalculatorThread(unit);
                threads.add(otherThread);
            }
        }
    }
}
