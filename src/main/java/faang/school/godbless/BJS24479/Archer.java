package faang.school.godbless.BJS24479;

public class Archer extends Character {

    private final static int ARCHER_STRENGTH = 3;
    private final static int ARCHER_DEXTERITY = 10;
    private final static int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_DEXTERITY, ARCHER_INTELLIGENCE);
    }

    @Override
    void attack(Character target) {
        target.setHealth(target.getHealth() - this.getDexterity());
    }
}
