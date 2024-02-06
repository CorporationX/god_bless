package faang.school.godbless.heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Creature {

    private String name;
    private int attack;
    private int defence;
    private int speed;
    private int count;

    public int getDamage() {
        return attack;
    }
}
