package school.faang.abstraction;

import lombok.ToString;

import static school.faang.abstraction.DefaultCharacteristics.archerIntelligence;
import static school.faang.abstraction.DefaultCharacteristics.archerSAgility;
import static school.faang.abstraction.DefaultCharacteristics.archerStrength;

@ToString(callSuper = true)
public class Archer extends Character {

    public Archer(String name) {
        super(name, archerStrength, archerSAgility, archerIntelligence);
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
        return this.agility;
    }
}
