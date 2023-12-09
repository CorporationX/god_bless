package faang.school.godbless.Abstraction;

public abstract class Character {
    String name;
    int power;
    int dexterity;
    int intellect;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    abstract void attack(Character character);
}
