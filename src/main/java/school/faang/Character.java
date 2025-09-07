package school.faang;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character opponent);

    protected void applyDamage(Character opponent, int damage) {
        opponent.health = Math.max(opponent.health - damage, 0);
    }
}

