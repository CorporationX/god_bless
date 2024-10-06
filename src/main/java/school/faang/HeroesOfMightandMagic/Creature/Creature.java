package school.faang.HeroesOfMightandMagic.Creature;

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

    public int getDamage(){
        return level*(attack+protection+speed);
    }
}
