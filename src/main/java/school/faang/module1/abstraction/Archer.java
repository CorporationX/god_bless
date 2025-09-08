package school.faang.module1.abstraction;

import lombok.ToString;

import static school.faang.module1.abstraction.DefaultCharacteristics.ARCHER_AGILITY;
import static school.faang.module1.abstraction.DefaultCharacteristics.ARCHER_INTELLIGENCE;
import static school.faang.module1.abstraction.DefaultCharacteristics.ARCHER_STRENGTH;
import static school.faang.module1.abstraction.DefaultCharacteristics.MINIMUM_CHARACTER_HP;

@ToString(callSuper = true)
public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        int damage = getCharacterDamage();

        if (opponent.getHitPoints() - damage <= MINIMUM_CHARACTER_HP) {
            opponent.setHitPoints(MINIMUM_CHARACTER_HP);
            return;
        }

        opponent.setHitPoints(opponent.getHitPoints() - damage);

        System.out.printf("Character %s attacked Character %s - %s hitPoints left%n",
                this.getName(), opponent.getName(), opponent.getHitPoints());
    }

    @Override
    public int getCharacterDamage() {
        return this.getAgility();
    }
}
