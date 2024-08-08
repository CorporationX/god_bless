package faang.school.godbless.BJS2_18982;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int protection;
    private int speed;
    private int quantity;
    private int health;

    public int getDamage() {
        return damage;
    }
}
