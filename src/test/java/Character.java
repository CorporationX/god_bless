public abstract class Character {
    protected String name;
    protected int power;
    protected String skil;
    protected String intelligence;
    protected boolean health;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, String intelligence, String skil, boolean health) {
        this.power = power;
        this.intelligence = intelligence;
        this.skil = skil;
        this.health = health;
    }
}
