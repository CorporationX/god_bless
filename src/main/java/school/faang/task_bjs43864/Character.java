package school.faang.task_bjs43864;

import static school.faang.task_bjs43864.BattleConfig.DEFAULT_AGILITY;
import static school.faang.task_bjs43864.BattleConfig.DEFAULT_INTELLIGENCE;
import static school.faang.task_bjs43864.BattleConfig.DEFAULT_POWER;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public abstract class Character {
    private final String name;
    private final int power;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.power = DEFAULT_POWER;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);
}
