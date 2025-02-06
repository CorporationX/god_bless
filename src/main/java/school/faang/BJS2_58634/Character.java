package school.faang.BJS2_58634;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int hp = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract void attack(Character opponent);
}
