package faang.school.godbless.Heroes.UI;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode
public abstract class Creature {
    @Getter
    protected String name;
    @NonNull
    protected int level;
    @NonNull
    protected int damage;
    @NonNull
    protected int protection;
    @NonNull
    protected int speed;
    @Getter
    @Setter
    protected int count = 0;

    public Creature(int level, int damage, int protection, int speed, int count) {
        this.level = level;
        this.damage = damage*(level);
        this.protection = protection*(level);
        this.speed = speed*(level);
        this.count += count;
    }


    public int summaryPower(){//сила юнита
        return speed+protection+damage+level;
    }
}
