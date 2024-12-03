package school.faang.sprint1.task_43819;

public class Warrior extends Character {
    private static final int WARRIOR_POWER = 10;
    private static final int WARRIOR_DEXTERITY = 5;
    private static final int WARRIOR_INTELLECT = 3;

    public Warrior(String name, int power, int dexterity, int intellect) {
        super(name, power, dexterity, intellect);
    }

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_DEXTERITY, WARRIOR_INTELLECT);
    }

    @Override
    public void attack(Character target) {
        target.takingDamage(WARRIOR_POWER);
    }
}
