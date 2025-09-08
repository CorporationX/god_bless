package school.faang.module1.abstraction;

import lombok.ToString;

import static school.faang.module1.abstraction.DefaultCharacteristics.MINIMUM_CHARACTER_HP;
import static school.faang.module1.abstraction.DefaultCharacteristics.WARRIOR_AGILITY;
import static school.faang.module1.abstraction.DefaultCharacteristics.WARRIOR_INTELLIGENCE;
import static school.faang.module1.abstraction.DefaultCharacteristics.WARRIOR_STRENGTH;

@ToString(callSuper = true)
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
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
        return this.getStrength();
    }
}
