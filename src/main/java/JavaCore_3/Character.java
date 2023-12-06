package JavaCore_3;

public abstract class Character {

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int adroitness, int intellect) {
        this.name = name;
        this.strength = strength;
        this.adroitness = adroitness;
        this.intellect = intellect;
    }

    private String name;
    protected int strength;
    protected int adroitness;
    private int intellect;
    public int health = 100;

    abstract public void attack(Character character);

}
