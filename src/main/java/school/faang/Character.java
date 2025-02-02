package school.faang;

public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    private int intelligence;
    protected int health = 100;

    public Character() {
    }

    public Character(String name) {
        validateName(name);
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        validateName(name);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void validateHealth() {
        if (health < 0) {
            throw new IllegalArgumentException("Health can't be below 0");
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }
    }
}
