package faang.school.godbless.heroesofmightandmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int defence;
    private int speed;
    private int quantity;
    private int damage;
}
