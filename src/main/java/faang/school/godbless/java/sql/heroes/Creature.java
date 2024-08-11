package faang.school.godbless.java.sql.heroes;


import lombok.Setter;

import java.util.Objects;

public abstract class Creature {
    // Constants
    public static final double SPEED_SCALING_FACTOR = 100.0;
    public static final double LEVEL_SCALING_FACTOR = 100.0;
    public static final double PROTECT_SCALING_FACTOR = 100.0;
    public static final int HEALTH_PER_UNIT = 100;
    public static final int DEFAULT_QUANTITY = 1;

    protected String name;
    @Setter
    protected int health = HEALTH_PER_UNIT;
    protected int level;
    protected int attack;
    protected int protect;
    protected int speed;
    protected int quantity = DEFAULT_QUANTITY;

    protected int getDamage() {
        int baseDamage = this.attack * this.quantity;

        double speedModifier = this.speed / Creature.SPEED_SCALING_FACTOR;
        double levelModifier = this.level / Creature.LEVEL_SCALING_FACTOR;

        double additionalSpeedDamage = baseDamage * speedModifier;
        double additionalLevelDamage = baseDamage * levelModifier;

        double totalDamage = baseDamage + additionalSpeedDamage + additionalLevelDamage;

        return (int) totalDamage;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }

    public void recalculateQuantityFromHealth() {
        this.quantity = (int) Math.ceil((double) this.health / Creature.HEALTH_PER_UNIT);
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
