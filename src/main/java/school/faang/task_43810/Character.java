package school.faang.task_43810;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int hp;

    public Character(String name) {
        this.name = name;
        this.hp = 100;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hp = 100;
    }

    public abstract void attack(Character character);

    public boolean isAlive() {
        if(hp > 0) {
            return true;
        }
        return false;
    }
}
