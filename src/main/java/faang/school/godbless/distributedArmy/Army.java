package faang.school.godbless.distributedArmy;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> units = new ArrayList<>();

    public void addUnitsToList(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<UnitThread> calculatePowerOfUnits = new ArrayList<>(); // юнеты
        for (Unit unit: units) {
            UnitThread thread = new UnitThread(unit.getPower()); // поток - юзер с силой
            calculatePowerOfUnits.add(thread);
            System.out.println("calculated...");
            Thread.sleep(1000);
            thread.start(); // запуск
        }
        return calculatePowerOfUnits.stream()
                .mapToInt(UnitThread::getTotalPower)
                .sum();
    }
}
