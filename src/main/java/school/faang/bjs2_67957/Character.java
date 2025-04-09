package school.faang.bjs2_67957;

import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.Setter;

import static school.faang.bjs2_67957.GameProperties.CHARACTER_AGILITY;
import static school.faang.bjs2_67957.GameProperties.CHARACTER_INTELLIGENCE;
import static school.faang.bjs2_67957.GameProperties.CHARACTER_STRENGTH;

@Setter
@Getter
@Slf4j
public abstract class Character {
    protected final String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;
    protected int health = 100;

    public Character(String name) {
        this(name, CHARACTER_STRENGTH, CHARACTER_AGILITY, CHARACTER_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character opponent);

    protected void reduceHealth(int damage) {
        health = Math.max(getHealth() - damage, 0);
        log.info("{} health {}", getName(), getHealth());
    }
}