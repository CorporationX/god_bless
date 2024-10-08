package heroes_of_might_and_magic;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;

    public abstract int getDamage();
}
