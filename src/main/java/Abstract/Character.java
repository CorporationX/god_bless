package Abstract;

public abstract class Character {
    protected static String name;
    protected static int power;
    protected static int  agility;
    protected static int intelligent;
    protected static int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligent) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligent = intelligent;
    }

    public abstract void atack(Character character);

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public static int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public static int getIntelligent() {
        return intelligent;
    }

    public void setIntelligent(int intelligent) {
        this.intelligent = intelligent;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Character.health = health;
    }
}
