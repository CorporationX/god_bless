package faang.school.godbless.BJS2_18932;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Creature {
    @Getter
    private String name;
    private int lvl;
    @Getter
    private int damage;
    private int defence;
    private int speed;
}
