package faang.school.godbless.Hiroes;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int defence;
    protected int speed;
    protected int quantity;

    public Creature(String name, int level, int damage, int defence, int speed) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", damage=" + damage +
                ", defence=" + defence +
                ", speed=" + speed +
                ", quantity=" + quantity +
                '}';
    }
}
