package faang.school.godbless.BJS218942;

public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    Character(String name) {
        this.name = name;
        this.health = 100;
    }

    Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character obj);

    @Override
    public String toString() {
        return String.format("%s (Health: %d)", name, health);
    }
}



