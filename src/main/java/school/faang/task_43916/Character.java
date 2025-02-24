package school.faang.task_43916;

public abstract class Character {
    String name;
    int strength;
    int dexterity;
    int intelligence;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);
}
