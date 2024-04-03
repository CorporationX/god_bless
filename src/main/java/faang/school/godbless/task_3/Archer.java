package faang.school.godbless.task_3;

public class Archer extends Character {
    private static final int STRENGTH = 2;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getDexterity());
    }
}
