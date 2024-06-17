package faang.school.godbless.BJS2_10938;

import java.util.HashMap;
import java.util.Map;

public class Army {
    // ключ - подразделение, значние - кол-во воинов
    private int totalArmyPower = 0;
    private final Map<Soldier, Integer> army = new HashMap<>();

    public void addUnitToArmy(Soldier soldier, int count) {
        army.put(soldier, count);
    }

    public int calculateTotalArmyPower() throws InterruptedException {
        for (var soldier: army.keySet()) {
            Thread thread = new Thread(() -> {
                totalArmyPower += army.get(soldier) * soldier.getPower();
            });

            // не знаю как иначе можно
            thread.start();
            thread.join();
        }

        return totalArmyPower;
    }
}
