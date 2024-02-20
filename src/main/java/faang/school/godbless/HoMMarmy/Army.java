package faang.school.godbless.HoMMarmy;

import faang.school.godbless.HoMMarmy.units.Unit;
import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<List<Object>> army = new ArrayList<>();

    public void addUnit(Unit unit, Integer count) {
        army.add(List.of(unit, count));
    }

    public void addUnit(Unit unit) {
        addUnit(unit, 1);
    }

    public int calculateTotalPower() {
        List<CalculatePowerThread> threads = new ArrayList<>();
        int totalPower = 0;
        for (List<Object> unitList : army) {
            CalculatePowerThread thread = new CalculatePowerThread((Unit) unitList.get(0), (Integer) unitList.get(1));
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
