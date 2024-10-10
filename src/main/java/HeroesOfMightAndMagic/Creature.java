package HeroesOfMightAndMagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;

    public int getDamage() {
        return getAttack() * getDefense() * getSpeed() * getLevel();
    }
}
