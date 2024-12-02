package school.faang.task_43502;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public boolean checkIsAlive(Character character) {
        boolean isAlive = true;
        if (this.health == 0) {
            System.out.println(getName() + " мертв и не может биться");
            isAlive= false;
        } else if (character.health == 0) {
            System.out.println(character.getName() + " уже убит");
            isAlive= false;
        }
        return isAlive;
    }

    public abstract void attack(Character character);
}
