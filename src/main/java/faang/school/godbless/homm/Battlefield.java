package faang.school.godbless.homm;

import java.util.Set;

public class Battlefield {
    public Hero battle(Hero hero1, Hero hero2) {
        for (Creature creature : hero1.getSquad()) {
            for (Creature enemy : hero2.getSquad()) {
                if (!creature.getDamage(enemy)) {
                    hero2.removeCreature(enemy, 1);
                } else {
                    hero2.removeCreature(creature, 1);
                }
                if (hero1.getSquad().isEmpty() || hero2.getSquad().isEmpty()) {
                    break;
                }
            }
        }
        return hero1.getSquad().size() > hero2.getSquad().size() ? hero1 : hero2;
    }
}
