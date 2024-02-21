package faang.school.godbless.HoMMarmy;

import faang.school.godbless.HoMMarmy.units.Unit;
import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit, Integer count) {
        unit.setCount(count);
        army.add(unit);
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        List<CalculatePowerThread> threads = new ArrayList<>();
        int totalPower = 0;
        for (Unit unit : army) {
            CalculatePowerThread thread = new CalculatePowerThread(unit, unit.getCount());
            thread.start();
            threads.add(thread);
        }
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalPower += thread.getTotalPower();
        }
        return totalPower;
    }
}
