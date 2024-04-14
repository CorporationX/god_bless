package faang.school.godbless.hashmap.heroes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int quantity;

    public abstract int getDamage();
}
