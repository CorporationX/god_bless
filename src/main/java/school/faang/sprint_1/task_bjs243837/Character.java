package school.faang.sprint_1.task_bjs243837;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public abstract class Character {
    private static final int DEFAULT_STRENGTH = 1;
    private static final int DEFAULT_AGILITY = 1;
    private static final int DEFAULT_INTELLIGENCE = 1;
    private static final int DEFAULT_HEALTH = 100;
    private static final boolean DEFAULT_ALIVE = true;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health;
    @Setter
    private boolean alive;

    protected Character(String name) {
        CharacterValidator.validateName(name);
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
        this.health = DEFAULT_HEALTH;
        this.alive = DEFAULT_ALIVE;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        CharacterValidator.validateName(name);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
        this.alive = DEFAULT_ALIVE;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            this.setAlive(false);
            System.out.println((this.getName() + " is dead."));
        }
        this.health = health;
    }

    public abstract void attack(Character opponent);
}
