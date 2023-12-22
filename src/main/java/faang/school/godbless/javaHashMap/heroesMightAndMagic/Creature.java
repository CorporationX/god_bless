package faang.school.godbless.javaHashMap.heroesMightAndMagic;

public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int protection;
    private int speed;
    private int count;

    public Creature(String name, int level, int damage, int protection, int speed, int count) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.protection = protection;
        this.speed = speed;
        this.count = count;
    }

    public int getDamage() {
        return damage;
    }
}

