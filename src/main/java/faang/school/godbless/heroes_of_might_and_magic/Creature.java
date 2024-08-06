package faang.school.godbless.heroes_of_might_and_magic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
abstract public class Creature {
    private String name;
    private int level;
    private int protection;
    private int speed;
    private int quantity;

    abstract public int getDamage();
}
