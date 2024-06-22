package faang.school.godbless.sprint3.armyOfSwordsAndMagicHeroes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateRunnable implements Runnable {

    private ArmyItem armyItem;
    private Integer power;

    public CalculateRunnable(ArmyItem armyItem) {
        this.armyItem = armyItem;
    }

    @Override
    public void run() {
       this.power = this.armyItem.getPower();
    }
}

