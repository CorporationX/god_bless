package school.faang.Abstraction;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int intellect;
    private int hp;
    private static final int DEFAULT_CHARACTERISTIC = 5;
    private static final int DEFAULT_HP = 100;

    public Character(String name) {

        this(name, DEFAULT_CHARACTERISTIC, DEFAULT_CHARACTERISTIC, DEFAULT_CHARACTERISTIC);
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.hp = DEFAULT_HP;
    }

    public abstract void attack(Character opponent);

    public void setHp(int hp) {
        this.hp = Math.max(this.hp - hp, 0);
    }
}
