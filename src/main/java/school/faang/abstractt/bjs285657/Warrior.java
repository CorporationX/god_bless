package school.faang.abstractt.bjs285657;

import static school.faang.abstractt.bjs285657.StartCharacteristics.MIN_HP;
import static school.faang.abstractt.bjs285657.StartCharacteristics.WARRIOR_DEXTERITY;
import static school.faang.abstractt.bjs285657.StartCharacteristics.WARRIOR_INTELLIGENCE;
import static school.faang.abstractt.bjs285657.StartCharacteristics.WARRIOR_STRENGTH;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_DEXTERITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        int damage = damage();

        opponent.setHealth(Math.max(opponent.getHealth() - damage, MIN_HP));

        System.out.printf("Character %s attack Character %s -  received %s damage left %s Health",
                this.getName(), opponent.getName(), damage, opponent.getHealth());

    }

    @Override
    public int damage() {
        return this.getStrength();
    }
}
