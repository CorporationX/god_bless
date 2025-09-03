package school.faang.abstraction;

import lombok.ToString;

import static school.faang.abstraction.DefaultCharacteristics.warriorIntelligence;
import static school.faang.abstraction.DefaultCharacteristics.warriorSAgility;
import static school.faang.abstraction.DefaultCharacteristics.warriorStrength;

@ToString(callSuper = true)
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, warriorStrength, warriorSAgility, warriorIntelligence);
    }

    @Override
    void attack(Character opponent) {
        int damage = characterDamage();

        if (opponent.hitPoints - damage <= 0) {
            opponent.hitPoints = 0;
            return;
        }

        opponent.hitPoints -= damage;

        System.out.printf("Character %s attacked Character %s - %s hitPoints left%n",
                this.name, opponent.name, opponent.hitPoints);
    }

    @Override
    int characterDamage() {
        return this.strength;
    }
}
