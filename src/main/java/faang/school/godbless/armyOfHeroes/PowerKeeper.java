package faang.school.godbless.armyOfHeroes;

import lombok.Getter;

@Getter
public class PowerKeeper extends Thread {

    private Integer powers;
    private ArmyUnit armyUnit;

    public PowerKeeper(ArmyUnit armyUnit) {
        this.armyUnit = armyUnit;
    }

    @Override
    public void run() {
        powers = armyUnit.getPower();
    }
}
