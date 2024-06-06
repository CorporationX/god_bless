package faang.school.godbless;

import lombok.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int protection;
    protected int speed;
    protected int peekNumber;


    int getDamage(){
        return  (int) (attack + (speed * 0.4) + (level * 0.8));
    }
}
