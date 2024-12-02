package school.faang.task_43804;

public class Warrior extends Character {
    private static final int POWER = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, POWER, DEXTERITY, INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.health -= power;
    }
}
