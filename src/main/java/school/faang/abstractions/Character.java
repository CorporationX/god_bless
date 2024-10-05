package school.faang.abstractions;

public abstract class Character {
    private static final int HEALTH_DEFAULT = 100;

    protected String name;
    protected int power;
    protected int skill;
    protected int intelligence;
    protected int health = HEALTH_DEFAULT;

    public Character(String name) {
        this(name, 0,0,0);
    }

    public Character(String name, int power, int skill, int intelligence) {
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", skill=" + skill +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}
