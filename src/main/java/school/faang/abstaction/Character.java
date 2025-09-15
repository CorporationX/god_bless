package school.faang.abstaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int iq;
    private int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int dexterity, int strength, int iq) {
        this.name = name;
        this.dexterity = dexterity;
        this.strength = strength;
        this.iq = iq;
    }

    public abstract void attack(Character opponent);

    public void receiveDamage(int damage) {
        // не совсем понял какая будет логика у этого метода
    }

    public void healthIsZero() {
        if (this.getHealth() < 0) {
            throw new IllegalArgumentException("Здоровье не может быть меньше 0");
        }
    }
}
