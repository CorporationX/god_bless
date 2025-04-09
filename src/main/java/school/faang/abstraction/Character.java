package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public abstract int getDamage();

    public void attack(Character otherCharacter) {
        if (otherCharacter.getHealth() <= 0) {
            return;
        }

        int damage = getDamage();
        otherCharacter.setHealth(otherCharacter.getHealth() - damage);
    }
}
