package faang.school.godbless.distributedArmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> UNITS = new ArrayList<>();

    public void addUnitsToList(Unit unit) {
        UNITS.add(unit);
    }

    public int calculateTotalPower() {
        List<UnitThread> calculatePowerOfUnits = new ArrayList<>(); // юнеты
        for (Unit unit : UNITS) {
            UnitThread thread = new UnitThread(unit.getPower()); // поток - юзер с силой
            calculatePowerOfUnits.add(thread);
            System.out.println("calculated...");
            thread.start(); // запуск
        }
        return calculatePowerOfUnits.stream()
                .peek(unitThread -> {
                    try {
                        unitThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .mapToInt(UnitThread::getTotalPower)
                .sum();
    }
}
