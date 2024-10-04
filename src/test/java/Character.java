public abstract class Character {
    protected String name;
    protected int power;
    protected int skil;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int intelligence, int skil) {
        this.power = power;
        this.intelligence = intelligence;
        this.skil = skil;
    }

    public abstract void attack(Character character);
}
