package heroesofswordandmagic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int defense;
    protected int speed;
    protected int quantity;

    public abstract int getDamage();

}
