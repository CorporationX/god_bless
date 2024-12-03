package school.faang.task_43810;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int hp = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public void reduceHp(int damage) {
        hp = hp - damage;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
