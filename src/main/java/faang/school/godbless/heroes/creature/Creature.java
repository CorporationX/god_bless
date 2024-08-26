package faang.school.godbless.heroes.creature;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Creature {

    private static final int DEFAULT_HEALTH_ONE_CREATURE = 100;

    protected String name;
    protected int level;
    protected int attack;
    protected int protection;
    protected int speed;
    protected int quantity;
    protected int health = DEFAULT_HEALTH_ONE_CREATURE;

    public Creature addQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
        return this;
    }

    public Creature removeQuantity(int quantity) {
        this.quantity = Math.max(0, this.quantity - quantity);
        return this;
    }

    public abstract int getDamage();

    public void attack(Creature creature) {
        int creatureHealthAfterAttack = Math.max(0, creature.health * creature.quantity - getDamage());
        creature.quantity = creatureHealthAfterAttack / DEFAULT_HEALTH_ONE_CREATURE;
    }
}
