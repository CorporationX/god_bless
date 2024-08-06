package faang.school.godbless.BJS2_18911;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class Creature {

    private String name;

    @Getter
    private int level;

    @Getter
    private int damage;

    private int defense;
    private int speed;
    private int quantity;
}
