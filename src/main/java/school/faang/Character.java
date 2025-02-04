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
        validateAgility(agility);
        validateIntelligence(intelligence);
        validateStrength(strength);

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

    private void validateStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException("Strength can't be below 0");
        }
    }

    private void validateAgility(int agility) {
        if (agility < 0) {
            throw new IllegalArgumentException("Agility can't be below 0");
        }
    }

    private void validateIntelligence(int intelligence) {
        if (intelligence < 0) {
            throw new IllegalArgumentException("Intelligence can't be below 0");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank");
        }
    }
}
