package faang.school.godbless.javahashmap.herouse;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public abstract class Creature {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int speed;

    public int getDamage() {
        return attack;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + ": {" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                '}';
    }
}
