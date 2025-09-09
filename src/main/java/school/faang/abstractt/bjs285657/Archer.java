package school.faang.abstractt.bjs285657;

import static school.faang.abstractt.bjs285657.StartCharacteristics.ARCHER_DEXTERITY;
import static school.faang.abstractt.bjs285657.StartCharacteristics.ARCHER_INTELLIGENCE;
import static school.faang.abstractt.bjs285657.StartCharacteristics.ARCHER_STRENGHT;
import static school.faang.abstractt.bjs285657.StartCharacteristics.MIN_HP;


public class Archer extends Character {
    public Archer(String name) {
        super(name, ARCHER_STRENGHT, ARCHER_DEXTERITY, ARCHER_INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        int damage = damage();

        if (opponent.getHealth() - damage <= MIN_HP) {
            opponent.setHealth(MIN_HP);
        } else {
            opponent.setHealth(opponent.getHealth() - damage);
        }
        System.out.printf("Character %s attack Character %s -  received %s damage left %s Health",
                this.getName(), opponent.getName(), damage, opponent.getHealth());

    }

    @Override
    public int damage() {
        return this.getDexterity();
    }

}
