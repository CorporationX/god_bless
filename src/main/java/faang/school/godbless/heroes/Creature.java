package faang.school.godbless.heroes;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public abstract class Creature {

    protected String name;
    protected int lvl;
    protected int attack;
    protected int protection;
    protected int speed;
    protected int amount;



    public int getDamage(){
        return (attack + speed) * lvl;
    }
}
