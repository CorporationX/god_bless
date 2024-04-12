package faang.school.godbless.Task_3;

public abstract class Character {
    String name;
    int strength;
    int agility;
    int intelligence;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    abstract void attack(Character character);
}
