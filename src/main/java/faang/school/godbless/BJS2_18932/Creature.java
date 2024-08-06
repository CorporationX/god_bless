package faang.school.godbless.BJS2_18932;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int lvl;
    @Getter
    private int damage;
    private int defence;
    private int speed;
}
