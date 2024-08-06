package faang.school.godbless.BJS2_18932;

import java.util.Map;

public class Battlefield {
    private static final String PROTAGONIST_NAME = "John";
    private static final String PROTAGONIST_FRACTION = "Light";
    private static final int PROTAGONIST_EXP = 30;
    private static final int PROTAGONIST_LVL = 2;

    private static final String ANTAGONIST_NAME = "Frank";
    private static final String ANTAGONIST_FRACTION = "Dark";
    private static final int ANTAGONIST_EXP = 10;
    private static final int ANTAGONIST_LVL = 5;

    private Hero protagonist;
    private Hero antagonist;

    public Battlefield(Hero protagonist, Hero antagonist) {
        this.protagonist = protagonist;
        this.antagonist = antagonist;
    }

    private int calculateArmyDamage(Hero hero) {
        int totalDamage = 0;
        for (Map.Entry<Creature, Integer> creature : hero.getArmy().entrySet()) {
            totalDamage += creature.getKey().getDamage() * creature.getValue();
        }
        return totalDamage;
    }

    public Hero battle() {
        if (calculateArmyDamage(protagonist) > calculateArmyDamage(antagonist))
            return protagonist;
        else {
            return antagonist;
        }
    }
}
