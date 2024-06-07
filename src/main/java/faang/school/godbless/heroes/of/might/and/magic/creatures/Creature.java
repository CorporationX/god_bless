package faang.school.godbless.heroes.of.might.and.magic.creatures;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int protection;
    protected int speed;
    @Setter
    protected int health;

    public void getDamage(Creature creature) {
        int opponentDamage = (int) ((creature.level + creature.attack + creature.speed) * 0.8);
        this.setHealth(this.health - opponentDamage);
    }

    @Override
    public String toString() {
        return name;
    }
}
