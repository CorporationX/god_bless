package school.faang.sprint_1.task_43833;

public class Warrior extends Character {
    public static final int FORCE = 10;
    public static final int AGILITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, FORCE, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        health -= character.getForce();
    }
}