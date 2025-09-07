package school.faang.bjs2_85572;

public class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;
    private final int DEFAULT_COUNTER = 5;

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_COUNTER;
        this.agility = DEFAULT_COUNTER;
        this.intelligence = DEFAULT_COUNTER;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void attack(Character opponent) {
    }

    public void printCheckLive(Character opponent) {
        if (opponent.getHealth() < 0) {
            opponent.health = 0;
            System.out.println("Противник мертв, атаковать нет мысла.");
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", power=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}