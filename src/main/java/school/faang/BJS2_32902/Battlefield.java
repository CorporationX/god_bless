package school.faang.BJS2_32902;

import school.faang.BJS2_32902.entity.Creature;

import java.util.List;

public class Battlefield {

    private final Hero hero1;
    private final Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        List<Creature> army1 = hero1.getArmy();
        List<Creature> army2 = hero2.getArmy();

        while (!army1.isEmpty() && !army2.isEmpty()) {
            for (int i = 0; i < Math.min(army1.size(), army2.size()); i++) {
                Creature creature1 = army1.get(i);
                Creature creature2 = army2.get(i);

                creature1.takeDamage(creature2.getDamage());
                creature2.takeDamage(creature1.getDamage());

                hero1.removeCreature(creature1, i);
                hero2.removeCreature(creature2, i);
            }
        }

        if (army1.isEmpty()) {
            return hero2;
        } else {
            return hero1;
        }
    }
}
