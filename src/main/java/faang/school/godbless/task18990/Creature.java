package faang.school.godbless.task18990;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Creature {
    public String name;
    public final int level;
    public final int attack;
    public final int protection;
    public final int speed;
    public int quantity;



    public  int getDamage(){
        return attack * quantity;
    };

}
