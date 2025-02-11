package school.faang.sprint1.task_56329;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public abstract class Character {
    private String name;
    @Setter
    private int strength;
    @Setter
    private int agility;
    @Setter
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.strength = power;
        this.agility = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void attackDamage(int damage) {
        this.health = Math.max(this.health - damage, 0);
    }
}
