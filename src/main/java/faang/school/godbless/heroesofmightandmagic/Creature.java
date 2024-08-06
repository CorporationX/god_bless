package faang.school.godbless.heroesofmightandmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int armor;
    private int speed;
    private int quantity;
}