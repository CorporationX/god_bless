package school.faang.task_43806.entity;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - DEFAULT_AGILITY);
    }
}
