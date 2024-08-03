package faang.school.godbless.HeroesOfMightAndMagic.Creatures;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public abstract class Creature {
    private String name;
    private int lvl;
    private int damage; //атака
    private int defence;

    public Creature(String name, int lvl, int damage, int defence) {
        this.name = name;
        this.lvl = lvl;
        this.damage = damage;
        this.defence = defence;
    }

}
