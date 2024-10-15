package school.faang.firstStream.BJS2_32875;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int protection;
    private int speed;
    private int hp;

    public int strikeEnemy(Creature creature) {
        return creature.getProtection() * creature.getLevel() - this.damage * this.level;
    }
}
