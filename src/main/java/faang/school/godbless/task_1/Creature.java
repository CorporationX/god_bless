package faang.school.godbless.task_1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Creature {
    protected final EnumNameAndAttackIsUnits enumNameAndAttack;
    protected int level;
    protected int protection;
    protected int speed;
    protected int quantity;
    protected int hp;


    public Creature(EnumNameAndAttackIsUnits enumNameAndAttack, int level, int protection, int speed,int hp, int quantity ) {
        this.enumNameAndAttack = enumNameAndAttack;
        this.level = level;
        this.protection = protection;
        this.speed = speed;
        this.hp = hp;
        this.quantity = quantity;
    }

    public abstract int getDamage();
}
