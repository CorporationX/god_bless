package faang.school.godbless.character;

public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    private int intelligence;
    protected int health = 100;

    Character(String name) {
        this.name = name;
    }

    Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
    }

    abstract void attack(Character anotherCharacter);
}
