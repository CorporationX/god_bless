package HeroesOfMightAndMagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;
    private int hp;
}
