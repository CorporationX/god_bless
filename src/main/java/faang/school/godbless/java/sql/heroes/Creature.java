package faang.school.godbless.java.sql.heroes;


import java.util.Objects;

public abstract class Creature {
    protected String name;
    protected int health;
    protected int level;
    protected int attack;
    protected int protect;
    protected int speed;
    protected int quantity;

    // Constants
    private static final double SPEED_SCALING_FACTOR = 100.0;
    private static final double LEVEL_SCALING_FACTOR = 100.0;
    private static final double PROTECT_SCALING_FACTOR = 100.0;
    private static final int HEALTH_PER_UNIT = 100;
    private static final int DEFAULT_QUANTITY = 1;

    public Creature(String name, int level, int attack, int protect, int speed) {
        this.name = name;
        this.health = Creature.HEALTH_PER_UNIT;
        this.level = level;
        this.attack = attack;
        this.protect = protect;
        this.speed = speed;
        this.quantity = Creature.DEFAULT_QUANTITY;
    }

    protected int getDamage() {
        // Calculate the base damage
        int baseDamage = this.attack * this.quantity;

        // Calculate damage modifier
        double speedModifier = this.speed / Creature.SPEED_SCALING_FACTOR;
        double levelModifier = this.level / Creature.LEVEL_SCALING_FACTOR;

        // Calculate additional damage
        double additionalSpeedDamage = baseDamage * speedModifier;
        double additionalLevelDamage = baseDamage * levelModifier;

        double totalDamage = baseDamage + additionalSpeedDamage + additionalLevelDamage;

        return (int) totalDamage;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }

    public void setHealth() {
        int baseHealth = Creature.HEALTH_PER_UNIT * this.quantity;
        double protectModifier = this.protect / Creature.PROTECT_SCALING_FACTOR;
        double additionalProtectDHealth = baseHealth * protectModifier;
        double finalHealth = baseHealth + additionalProtectDHealth;
        this.health = (int) finalHealth;
    }

    public void recalculateQuantityFromHealth() {
        this.quantity = (int) Math.ceil((double) this.health / Creature.HEALTH_PER_UNIT);
    }

    @Override
    public String toString() {
        return String.format("%s; quantity - %d; health - %d", this.name, this.quantity, this.health);
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
