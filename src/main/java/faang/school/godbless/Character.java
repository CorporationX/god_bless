package faang.school.godbless;

public abstract class Character {
    String name;
    int strength;
    int agility;
    int intelligence;
    int health = 100;

    public abstract void attack(Character enemy);
}
