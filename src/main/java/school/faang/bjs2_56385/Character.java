package school.faang.bjs2_56385;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public abstract class Character {
    protected final String name;
    protected int strenght;
    protected int agility;
    protected int intelligence;
    private int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strenght, int agility, int intelligence) {
        this.name = name;
        this.strenght = strenght;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(Character opponent, int damage) {
        opponent.health = Math.max(opponent.health - damage, 0);
    }
}

