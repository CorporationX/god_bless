package faang.school.godbless.hashmap7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Creature {
    private final String name;
    private final int lvl;
    @Getter
    private final int damage;
    private final int defense;
    private final int speed;
    @Setter
    @Getter
    private int quantity;

}
