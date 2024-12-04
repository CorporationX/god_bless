package school.faang.sprint_1.task_43833;

public class Archer extends Character {
    public static final int FORCE = 3;
    public static final int AGILITY = 10;
    public static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, FORCE, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        health -= character.getAgility();
    }
}