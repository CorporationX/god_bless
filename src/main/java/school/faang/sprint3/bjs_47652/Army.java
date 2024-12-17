package school.faang.sprint3.bjs_47652;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<Unit> myArmy = new ArrayList<>();

    public void addUnit(Unit unit) {
        myArmy.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;

        for (Unit unit : myArmy) {
            UnitThread unitThread = new UnitThread(unit);
            unitThread.start();
            try {
                unitThread.join();
            } catch (InterruptedException exception) {
                log.error(exception.getMessage());
            }
            totalPower += unitThread.getPower();
        }
        return totalPower;
    }
}


