package distributedArmy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Army {

   private Map<String, ArrayList<Unit>> army = new HashMap<>();

    int calculateTotalPower() {
        int totalPower = 0;

        ArrayList<PowerThread> threads = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Unit>> armyUnit : army.entrySet()) {
            for (Unit unit : armyUnit.getValue()) {
                PowerThread thread = new PowerThread(unit);
                threads.add(thread);
                thread.start();
            }
        }

        for (PowerThread thread : threads) {
            totalPower += thread.getPower();
        }

        return totalPower;
    }

    void addUnit(Unit unit) {
        army.computeIfAbsent(unit.getClass().getName(), unitsByType -> new ArrayList<>()).add(unit);
    }
}
