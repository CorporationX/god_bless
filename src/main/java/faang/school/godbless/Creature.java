package faang.school.godbless;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int protection;
    protected int speed;
    protected int quantity;

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
}