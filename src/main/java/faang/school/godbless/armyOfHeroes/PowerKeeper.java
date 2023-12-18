package faang.school.godbless.armyOfHeroes;

import java.util.List;

public class PowerKeeper implements Runnable {

    private List<Integer> powers;
    private ArmyItem armyItem;

    public PowerKeeper(List<Integer> powers, ArmyItem armyItem) {
        this.powers = powers;
        this.armyItem = armyItem;
    }

    @Override
    public void run() {
        powers.add(armyItem.getPower());
    }
}
