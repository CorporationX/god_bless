package school.faang.rpg;

public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void attack(Character opponent);

    protected void receiveDamage(int damage) {
        this.health = Math.max(this.health - damage, 0);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return "Character {"
                + "name = " + name
                + ", power = " + power
                + ", dexterity = " + dexterity
                + ", intellect = " + intellect
                + ", health = " + health + '}';
    }
}
