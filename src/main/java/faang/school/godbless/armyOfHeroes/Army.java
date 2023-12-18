package faang.school.godbless.armyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<ArmyItem> fullArmy;

    public Army() {
        this.fullArmy = new ArrayList<>();
    }

    public int calculateTotalPower() {
        List<Integer> powersByItem = new ArrayList<>();
        for (int i = 0; i < fullArmy.size(); i++) {
            new Thread(new PowerKeeper(powersByItem, fullArmy.get(i))).start();
        }
        return powersByItem.stream().mapToInt(Integer::intValue).sum();
    }

    public void addUnit(ArmyItem armyItem) {
        fullArmy.add(armyItem);
    }
}
