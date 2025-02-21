package school.faang.task_58525;

public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;
    private static final int DEFAULT_POINTS = 5;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_POINTS;
        this.agility = DEFAULT_POINTS;
        this.intelligence = DEFAULT_POINTS;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Character{name: " + name + ", strength: " + strength +
                ", agility: " + agility + ", intelligence: " + intelligence +
                ", health: " + health + "}";
    }

    public abstract void attack(Character opponent);

    public void checkHealth() {
        if (health < 0) {
            throw new CharacterDefeatedException("Character " + name + " died");
        }
    }
}
