package faang.school.godbless.game;

public abstract class Creature {
    private String name;
    private int level;//1-4
    private int attack;
    private int defense;
    private int speed;
    private int quantity;//health

    public Creature(String name, int level, int attack, int defense, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.quantity = quantity;
    }

    public abstract int getDamage();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", quantity=" + quantity +
                '}';
    }
}
