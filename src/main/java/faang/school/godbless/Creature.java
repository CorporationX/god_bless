package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature {
    protected String Name;
    protected Long Level;
    protected Long Damage;
    protected Long Defense;
    protected Long Speed;
    protected Long Quantity;

    public Creature(String name, Long level, Long damage, Long defense, Long speed, Long quantity) {
        Name = name;
        Level = level;
        Damage = damage;
        Defense = defense;
        Speed = speed;
        Quantity = quantity;
    }


    @Override
    public String toString() {
        return "Creature{" +
                "Name='" + Name + '\'' +
                ", Level=" + Level +
                ", Damage=" + Damage +
                ", Defense=" + Defense +
                ", Speed=" + Speed +
                ", Quantity=" + Quantity +
                '}';
    }
}
