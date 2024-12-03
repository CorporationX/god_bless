package school.faang.task_43825;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    protected void attack(Character target) {
        target.setHealth(target.getHealth() - DEXTERITY);
    }

}
