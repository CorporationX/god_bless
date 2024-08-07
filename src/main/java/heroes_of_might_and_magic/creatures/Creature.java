package heroes_of_might_and_magic.creatures;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Creature {
    protected String name;
    protected int level;
    protected int health;
    protected int damage;
    protected int armor;
    protected int speed;

    public Creature(String name) {
        this.name = name;
    }
}
