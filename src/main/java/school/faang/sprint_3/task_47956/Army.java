package school.faang.sprint_3.task_47956;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        try {
            Map<String, List<Unit>> unitsByType = units.stream()
                    .collect(Collectors.groupingBy(Unit::getUnitType));

            int totalPower = 0;

            for (Map.Entry<String, List<Unit>> entry : unitsByType.entrySet()) {
                String unitType = entry.getKey();
                List<Unit> unitList = entry.getValue();

                PowerCalculatorThread thread = new PowerCalculatorThread(unitList);
                thread.start();
                thread.join();

                int power = thread.getTotalPower();
                System.out.println("Общая сила " + unitType.toLowerCase() + ": " + power);

                totalPower += power;
            }

            System.out.println("Общая сила армии: " + totalPower);
            return totalPower;
        } catch (InterruptedException e) {
            System.err.println("Ошибка при выполнении потока: " + e.getMessage());
            Thread.currentThread().interrupt();
            return 0;
        }
    }
}
