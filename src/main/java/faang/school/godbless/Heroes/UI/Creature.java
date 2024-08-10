package faang.school.godbless.Heroes.UI;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.annotation.processing.SupportedAnnotationTypes;

@EqualsAndHashCode
@Getter
@Setter
@NonNull
public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int protection;
    protected int speed;
    protected int count = 0;

    Creature(String name, int level, int damage, int protection, int speed, int count) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.protection = protection;
        this.speed = speed;
        this.count += count;
    }

    public abstract int summaryPower();
}
