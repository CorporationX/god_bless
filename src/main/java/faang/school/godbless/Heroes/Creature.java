package faang.school.godbless.Heroes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;

    public abstract int getDamage();
}
