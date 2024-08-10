package faang.school.godbless.BJS2_18834;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character character);
}
