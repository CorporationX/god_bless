package faang.school.godbless.heroes_of_might_and_magic_iii;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
public abstract class Creature {
    final private String name;
    final private int level;
    final private int attack;
    final private int defence;
    final private int speed;
//    implementing amount of units through this is sooo0000 overengineering
    final private int amount;

//    I dont really know how this supposed to be calculated
    public int getDamage() {
        return attack;
    }
}
