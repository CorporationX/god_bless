package school.faang.abstraction;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {

    private String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = HeroSettings.MAX_XP;
    private boolean isAlive = true;

    public Character(@NonNull String name) {
        this.name = name;
        this.strength = HeroSettings.DEFAULT_VALUE_CHARACTER;
        this.agility = HeroSettings.DEFAULT_VALUE_CHARACTER;
        this.intelligence = HeroSettings.DEFAULT_VALUE_CHARACTER;
    }

    public Character(@NonNull String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public abstract void attack(Character opponent);

    protected void processDeathHero() {
        if (this.getHealth() <= 0) {
            this.setHealth(0);
            this.isAlive = false;
            System.out.println("Противниг погиб");
        }
    }
}