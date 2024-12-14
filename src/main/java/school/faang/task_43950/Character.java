package school.faang.task_43950;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;

    protected final String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;

    protected int health;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = (name == null || name.isEmpty()) ? "Homeless" : name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        this.health -= damage;
        log.info("{} -> -{} -> HP: {}", this.name, damage, this.health);
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}