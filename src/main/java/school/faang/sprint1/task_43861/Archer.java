package school.faang.sprint1.task_43861;

public class Archer extends Character {

    public Archer(String name) {
        super(name, STRENGTH_VALUE, AGILITY_VALUE, INTELLIGENCE_VALUE);
    }

    @Override
    void attack(Character character) {
        character.consumeDamage(getAgility());
    }

    private static final int STRENGTH_VALUE = 3;
    private static final int AGILITY_VALUE = 10;
    private static final int INTELLIGENCE_VALUE = 5;
}
