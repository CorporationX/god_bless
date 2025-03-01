package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {
    private static final int DEFAULT_SKILL_VALUE = 5;
    private String name;
    private int force;
    private int dexterity;
    private int intellect;
    private int health = 100;

    protected Character(String name) {
        this(name, DEFAULT_SKILL_VALUE,
                DEFAULT_SKILL_VALUE, DEFAULT_SKILL_VALUE);

    }

    protected Character(String name, int force, int dexterity, int intellect) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intellect = intellect;

    }

    public abstract void attack(Character opponent);

    public void decreasedHealth(Character opponent, int damage) {
        int newHealth = opponent.getHealth() - damage;
        opponent.setHealth(Math.max(newHealth, 0));
    }


}

