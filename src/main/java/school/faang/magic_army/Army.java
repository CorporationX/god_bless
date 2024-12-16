package school.faang.magic_army;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<Unit> armyUnits = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyUnits.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<PowerCounter> unitPowers = new ArrayList<>();

        armyUnits.forEach(unit -> {
            PowerCounter powerCounter = new PowerCounter(unit);
            unitPowers.add(powerCounter);
            powerCounter.start();
        });

        for (PowerCounter powerCounter : unitPowers) {
            try {
                powerCounter.join();
                totalPower += powerCounter.getCurrentPower();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }

        return totalPower;
    }
}
