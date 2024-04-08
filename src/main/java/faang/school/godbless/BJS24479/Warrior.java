package faang.school.godbless.BJS24479;

public class Warrior extends Character {
    private final static int WARRIOR_STRENGTH = 10;
    private final static int WARRIOR_DEXTERITY = 5;
    private final static int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_DEXTERITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }
}
