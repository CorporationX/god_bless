package school.faang.BJS2_31295;

public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        setName(name);
    }

    public Character(String name, int power, int agility, int intelligence) {
        setName(name);
        setPower(power);
        setAgility(agility);
        setIntelligence(intelligence);
    }

    public abstract void attack(Character character);

    private void validateName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Invalid name.");
    }

    private void validatePower(int power) {
        if (power <= 0)
            throw new IllegalArgumentException("Invalid power value. Must be at least 1.");
    }

    private void validateAgility(int agility) {
        if (agility <= 0)
            throw new IllegalArgumentException("Invalid agility value. Must be at least 1.");
    }

    private void validateIntelligence(int intelligence) {
        if (intelligence <= 0)
            throw new IllegalArgumentException("Invalid intelligence value. Must be at least 1.");
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setPower(int power) {
        validatePower(power);
        this.power = power;
    }

    private void setAgility(int agility) {
        validateAgility(agility);
        this.agility = agility;
    }

    private void setIntelligence(int intelligence) {
        validateIntelligence(intelligence);
        this.intelligence = intelligence;
    }
}
