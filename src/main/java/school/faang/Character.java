package school.faang;

import lombok.Getter;
import lombok.Setter;

abstract class Character {

    @Getter @Setter
    protected String name;
    @Getter @Setter
    protected int strength;
    @Getter @Setter
    protected int dexterity;
    @Getter @Setter
    protected int intelligence;
    @Getter @Setter
    private int health = 100;

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        if (health <= 0) {
            throw new IllegalStateException(name + " is dead and cannot act");
        }
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.dexterity = 5;
        this.intelligence = 5;
    }

    protected boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public abstract void attack(Character character);
}
