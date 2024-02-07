package faang.school.godbless.r_edzie.heroes;

public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defense;
    private int speed;
    private int count;

    public Creature(String name, int level, int damage, int defense, int speed, int count) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.count = count;
    }

    public int getDamage() {
        return damage;
    }
}
