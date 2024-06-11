package faang.school.godbless.heroes_might_and_magic.entity.creature;


public abstract class Creature {
    protected String name;
    protected int level;
    protected int HEALTH = 100;
    protected int damage;
    protected int defense;
    protected int speed;
    protected int count;

    public int getDamage() {
        return damage * speed + level * damage;
    }

    public Creature(int count) {
        this.count = count;
    }

    public Creature(String name, int level, int damage, int defense, int speed, int count) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.count = count;
    }

    public int getHealth() {
        return HEALTH;
    }

    public void setHealth(int health) {
        this.HEALTH = health;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", health=" + HEALTH +
                ", damage=" + damage +
                ", defense=" + defense +
                ", speed=" + speed +
                ", count=" + count +
                '}';
    }
}
