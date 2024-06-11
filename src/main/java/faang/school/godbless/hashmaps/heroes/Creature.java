package faang.school.godbless.hashmaps.heroes;

public abstract class Creature {
    private static final double DEFAULT_HEALTH = 100.0;

    protected String name;
    protected double health;
    protected double level;
    protected double attack;
    protected double protection;
    protected double speed;

    public Creature(String name, double level, double attack, double protection, double speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.health = DEFAULT_HEALTH * (1 + level / 2);
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", attack=" + attack +
                ", protection=" + protection +
                ", speed=" + speed +
                ", health=" + health +
                '}';
    }

    public void takeDamage(double damage) {
        health -= damage - level + (protection + 0.1 * speed);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract double getDamage();
}
