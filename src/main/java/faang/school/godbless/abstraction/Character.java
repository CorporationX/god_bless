package faang.school.godbless.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {

    private static final int BASE_HP = 100;

    protected String name;
    protected int hp = BASE_HP;
    protected int power;
    protected int agility;
    protected int intellect;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character otherCharacter);
}
