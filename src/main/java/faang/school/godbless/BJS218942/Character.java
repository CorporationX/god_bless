package faang.school.godbless.BJS218942;

public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    Character(String name) {
        this.name = name;
    }

    Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character obj);

    @Override
    public String toString() {
        return String.format("%s (Health: %d)", name, health);
    }
}



