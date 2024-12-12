package school.faang.sprint1.task_43861;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name, STRENGTH_VALUE, AGILITY_VALUE, INTELLIGENCE_VALUE);
    }

    @Override
    void attack(Character character) {
        character.consumeDamage(getStrength());
    }

    private static final int STRENGTH_VALUE = 10;
    private static final int AGILITY_VALUE = 5;
    private static final int INTELLIGENCE_VALUE = 3;
}
