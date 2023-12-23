package faang.school.godbless.armyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<ArmyUnit> fullArmy;
    private List<PowerKeeper> powerKeepers;

    public Army() {
        this.powerKeepers = new ArrayList<>();
        this.fullArmy = new ArrayList<>();
    }

    public int calculateTotalPower() {
        Integer totalPowers = 0;
        for (int i = 0; i < fullArmy.size(); i++) {
            PowerKeeper powerKeeper = new PowerKeeper(fullArmy.get(i));
            powerKeeper.start();
            powerKeepers.add(powerKeeper);
        }
        for (PowerKeeper powerKeeper : powerKeepers) {
            try {
                powerKeeper.join();
                totalPowers += powerKeeper.getPowers();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPowers;
    }

    public void addUnit(ArmyUnit armyUnit) {
        fullArmy.add(armyUnit);
    }
}
