package Mathew;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Creature {
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int amount;

    public static int getDamage(Creature creature) {
       return creature.getAttack();
    }
}
