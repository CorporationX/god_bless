package faang.school.godbless.HeroesOfMightAndMagic2045.Troops;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Creature {
    private String name;
    private int lvl;
    private int attack;
    private int defence;
    private int speed;
    private int quantity;

    Creature(int lvl) {
        this.lvl = lvl;
    }

    public int getDamage(Creature defender) {
        int damage = (this.attack + this.speed) - defender.getDefence();
        return Math.max(0, damage);
    }
}
