package faang.school.godbless;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int protection;
    protected int speed;
    protected int quantity;
    protected int allDamage;
    protected int allProtection;

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void attack(Creature creature) {
        this.allProtection -= creature.allDamage;
        creature.allProtection -= this.allDamage;

        if (this.allProtection - creature.allDamage < 0 && creature.allProtection - this.allDamage < 0) {
            if (this.speed > creature.speed)
            else this.allProtection = 0;
        }

        if (this.allProtection - creature.allDamage > 0 && creature.allProtection - this.allDamage < 0) {
            if (this.speed > creature.speed) creature.allProtection = 0;
            else this.allProtection = 0;
        }

        if (this.allProtection - creature.allDamage < 0 && creature.allProtection - this.allDamage > 0) {
            creature.allProtection = 0;
        }
        this.protection * this.quantity -= (creature.damage * creature.quantity);
        creature.protection -= this.damage;

        //if (this.protection > creature.damage && this.damage > creature.protection && this.speed > creature.speed) {
        //    creature.quantity -=
        //}
    }
}