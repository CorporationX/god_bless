package faang.school.godbless.task_1;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int attack, int defense, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract int getDamage();
    public String toString(){
        return "name = "+name+", level = "+level+", defence = "+defense+", speed = "+speed+", attack = "+attack;
    }
}
