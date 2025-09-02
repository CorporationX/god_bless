package school.faang.bjs286658;

public abstract class Character {
    protected int HEALTH = 100;

    protected final String name;
    protected final int power;
    protected final int agility;
    protected final int intelligence;

    public Character(String name) {
        this.name = name;
        this.power = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void takeDamage(int damage) {
        this.HEALTH = Math.max(0, this.HEALTH - damage);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "%s {strength=%d, agility=%d, intelligence=%d, health=%d}",
                name, power, agility, intelligence, HEALTH
        );
    }
}
