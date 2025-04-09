package school.faang.bjs2_68146;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public Character(String name, int strength, int agility, int intelligence) {
        if (strength < 0 || agility < 0 || intelligence < 0) {
            log.error("Attempted to create Character with negative strength, agility, or intelligence. "
                    + "Strength, agility, and intelligence must be non-negative integers.");
            throw new IllegalArgumentException("Strength, agility, and intelligence must be non-negative integers.");
        }
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        if (name == null || name.isBlank()) {
            log.error("Attempted to create Character with a blank or null name. Name must be a non-blank string.");
            throw new IllegalArgumentException("Name must be a non-blank string.");
        }
        this.name = name;
        log.info("Successfully created Character with name = {}, strength = {}, agility = {}, and intelligence = {}",
                name, strength, agility, intelligence);
    }

    public abstract void attack(Character character);

    public void takeDamage(int damage) {
        if (damage < 0) {
            log.error("Attempted to take negative damage. Damage must be a non-negative integer.");
            throw new IllegalArgumentException("Damage must be a non-negative integer.");
        }
        this.health -= damage;
        log.info("Character {} took {} damage. Health remaining = {}", name, damage, this.health);
        if (this.health < 0) {
            this.health = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s Health: %d", name, health);
    }
}
