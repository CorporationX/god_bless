package school.faang;

public abstract class Character {
    protected String name;
    protected int strengh;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strengh, int dexterity, int intelligence) {
        this.name = name;
        this.strengh = strengh;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void attack(Character character) {
    }
}