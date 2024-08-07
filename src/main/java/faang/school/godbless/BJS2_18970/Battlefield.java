package faang.school.godbless.BJS2_18970;

import java.util.Random;

public class Battlefield {

    private Hero heroAttack;
    private Hero heroDefence;

    public Battlefield(Hero heroAttack, Hero heroDefence) {
        this.heroAttack = heroAttack;
        this.heroDefence = heroDefence;
    }

    Hero battle() {
        while (!heroAttack.getArmy().isEmpty() || !heroDefence.getArmy().isEmpty()) {
            Random r = new Random();
            int nextInt = r.nextInt(10);
            if (nextInt % 2 == 0) {
                Creature creature = heroAttack.attack(heroDefence);
                if (creature != null) {
                    heroDefence.getArmy().remove(creature);
                }
            } else {
                Creature creature = heroDefence.attack(heroAttack);
                if (creature != null) {
                    heroAttack.getArmy().remove(creature);
                }
            }
        }

        return heroAttack.getArmy().isEmpty() ? heroDefence : heroAttack;
    }
}
