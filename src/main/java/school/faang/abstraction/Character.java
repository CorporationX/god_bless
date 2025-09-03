package school.faang.abstraction;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static school.faang.abstraction.DefaultCharacteristics.characterAgility;
import static school.faang.abstraction.DefaultCharacteristics.characterIntelligence;
import static school.faang.abstraction.DefaultCharacteristics.characterStrength;

@ToString
@RequiredArgsConstructor
public abstract class Character {
    protected final String name;
    protected final Integer strength;
    protected final Integer agility;
    protected final Integer intelligence;
    protected Integer hitPoints = 100;

    public Character(String name) {
        this.name = name;
        strength = characterStrength;
        agility = characterAgility;
        intelligence = characterIntelligence;
    }

    abstract void attack(Character opponent);

    abstract int characterDamage();
}
