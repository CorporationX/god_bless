package school.faang.task_43838.entity;

public class Warrior extends Character {
    private static final Integer DEFAULT_STRENGTH = 10;
    private static final Integer DEFAULT_AGILITY = 5;
    private static final Integer DEFAULT_INTELLIGENCE = 3;


    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - DEFAULT_STRENGTH);
    }
}
