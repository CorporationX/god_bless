package school.faang.BJS2_56385;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
public abstract class Character {
    public String name;
    public int strenght;
    public int agility;
    public int intelligence;
    public int health = 100;

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

    protected void reduceStrength(Character opponent, int damage) {
        opponent.health = Math.max(opponent.health - damage, 0);
    }
}

