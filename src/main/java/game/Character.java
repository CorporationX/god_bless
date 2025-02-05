package game;

abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    /**
     * Constructor with default attributes.
     *
     * @param name Character name
     */
    protected Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
        this.health = 100;
    }

    /**
     * Constructor with custom attributes.
     *
     * @param name Character name
     * @param strength Strength attribute
     * @param agility Agility attribute
     * @param intelligence Intelligence attribute
     */
    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character opponent);

    /**
     * Method to receive damage.
     *
     * @param damage Amount of damage taken
     */
    protected void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
        System.out.println(name + " takes " + damage + " damage. Remaining health: " + health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
