package school.faang.task_43825;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    protected void attack(Character target) {
        target.setHealth(target.getHealth() - STRENGTH);
    }

}
