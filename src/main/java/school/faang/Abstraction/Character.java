package school.faang.Abstraction;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int intellect;
    private int hp;

    public Character(String name) {
        this.name = name;
        this.power = 5;
        this.dexterity = 5;
        this.intellect = 5;
        this.hp = 100;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.hp = 100;
    }

    public abstract void attack(Character opponent);

    public void setHp(int hp) {
        if ((this.hp - hp) < 0) {
            this.hp = 0;
        } else {
            this.hp -= hp;
        }
    }
}
