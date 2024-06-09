package faang.school.godbless.module1.sprint1.task8;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public abstract class Creature {
    protected String name;
    protected int lvl;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int heals;

    int getDamage(){
        return (int) (attack +
                (speed * 0.4) +
                (lvl * 0.8));
    }
}
