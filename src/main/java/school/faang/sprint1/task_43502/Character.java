package school.faang.sprint1.task_43502;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static school.faang.sprint1.task_43502.CharacterConfigurations.DEFAULT_AGILITY;
import static school.faang.sprint1.task_43502.CharacterConfigurations.DEFAULT_INTELLIGENCE;
import static school.faang.sprint1.task_43502.CharacterConfigurations.DEFAULT_STRENGTH;

@ToString
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public abstract class Character {

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character characterToAttack);
}
