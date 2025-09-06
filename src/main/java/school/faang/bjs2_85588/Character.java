package school.faang.bjs2_85588;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public boolean isAlive() {
        if (this.health == 0) {
            System.out.println(this.name + " Повержен!");
            return false;
        }
        return true;
    }
}
