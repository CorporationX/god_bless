package school.faang.task_43804;

public class Archer extends Character {
    private static final int POWER = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, POWER, DEXTERITY, INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.health -= dexterity;
    }
}
