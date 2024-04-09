package faang.school.godbless.module.hashmap.heroes.creature;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int defence;
    protected int speed;
    protected int quantity;
}
