package school.faang;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name, int strength, int agility, int intelligence) {
        setName(name);
        setStrength(strength);
        setAgility(agility);
        setIntelligence(intelligence);
        setHealth(100);
    }

    public Character(String name) {
        setName(name);
        setHealth(100);
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public void attack(Character target) {}
}

