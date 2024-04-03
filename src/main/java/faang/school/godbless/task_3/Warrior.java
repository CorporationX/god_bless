package faang.school.godbless.task_3;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}
