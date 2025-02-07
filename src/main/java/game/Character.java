package game;

public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private  int health = 100;

    /**
     * Constructor with default attributes.
     *
     * @param name Character name
     */
    public Character(String name) {
        this(name, 5, 5, 5);
    }

    /**
     * Constructor with custom attributes.
     *
     * @param name Character name
     * @param strength Strength attribute
     * @param agility Agility attribute
     * @param intelligence Intelligence attribute
     */
    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    /**
     * Method to receive damage.
     *
     * @param damage Amount of damage taken
     */
    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
        System.out.printf("%s takes %d damage. Remaining health: %d%n", name, damage, health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
