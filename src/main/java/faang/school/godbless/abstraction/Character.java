package faang.school.godbless.abstraction;

public abstract class Character {
    protected String name;
    protected int force;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int dexterity, int intelligence) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);

    @Override
    public String toString() {
        return "Character: " + name + "\n" +
                "force: " + force +
                ", dexterity: " + dexterity +
                ", intelligence: " + intelligence +
                ", health: " + health + "\n";
    }
}

