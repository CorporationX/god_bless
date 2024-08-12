package faang.school.godbless.java.sql.heroes;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Setter
@Getter
public abstract class Creature {


    protected String name;
    protected int health = Constants.HEALTH_PER_UNIT;
    protected int level;
    protected int attack;
    protected int protect;
    protected int speed;
    protected int quantity = Constants.DEFAULT_QUANTITY;

    protected int getDamage() {
        int baseDamage = this.attack;

        double speedModifier = this.speed / Constants.SPEED_SCALING_FACTOR;
        double levelModifier = this.level / Constants.LEVEL_SCALING_FACTOR;

        double additionalSpeedDamage = baseDamage * speedModifier;
        double additionalLevelDamage = baseDamage * levelModifier;

        double totalDamage = baseDamage + additionalSpeedDamage + additionalLevelDamage;

        return (int) totalDamage;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }


    @Override
    public String toString() {
        return String.format("{%s, quantity - %d, health - %d}", this.name, this.quantity, this.health);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Creature creature = (Creature) obj;
        return Objects.equals(this.name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
