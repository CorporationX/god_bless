package faang.school.godbless.task18990;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Creature {
    public String name;
    public int level;
    public int attack;
    public int protection;
    public int speed;
    public int quantity;

    public  int getDamage(){
        return attack;
    };

}
