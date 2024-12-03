package school.faang.sprint1.task_43819;

public class Archer extends Character {
    private static final int ARCHER_POWER = 3;
    private static final int ARCHER_DEXTERITY = 10;
    private static final int ARCHER_INTELLECT = 5;

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_DEXTERITY, ARCHER_INTELLECT);
    }

    @Override
    public void attack(Character target) {
        target.takingDamage(ARCHER_DEXTERITY);
    }
}
