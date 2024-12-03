package school.faang.task_43807;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int intellect;
    private int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health = 100;
    }

    public abstract void attack(Character other);
}
