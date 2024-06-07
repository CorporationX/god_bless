package faang.school.godbless.heroes.of.might.and.magic.creatures;

import faang.school.godbless.heroes.of.might.and.magic.heros.Hero;
import lombok.Getter;

@Getter
public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int protection;
    protected int speed;
    protected int quantity;

    public Creature(int quantity){
        this.quantity = quantity;
    }

    public int getDamage() {
        return (level + attack + speed);
    }

    public void herosInfluence(Hero hero){
    }
}
