package heroes.of.might.and.magic;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@ToString
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private final int quantity = 1;

    public int getDamage() {
        return this.attack * this.level + this.speed;
    }
}
