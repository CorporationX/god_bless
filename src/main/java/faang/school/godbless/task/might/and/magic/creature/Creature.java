package faang.school.godbless.task.might.and.magic.creature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Creature {
    protected String name;
    protected int level;
    protected double health;
    protected double damage;
    protected double defence;
    protected double movement;
    protected int quantity;

    public abstract void reloadHealth();

    public abstract void reloadDamage();
}
