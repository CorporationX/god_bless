package school.faang.BJS2_58634;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int DEFAULT_SKILL_VALUE = 5;
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int hp = 100;


    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_SKILL_VALUE;
        this.agility = DEFAULT_SKILL_VALUE;
        this.intelligence = DEFAULT_SKILL_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }

    public abstract void attack(Character opponent);

}