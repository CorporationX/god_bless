package faang.school.godbless.task_003;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character enemy) {
        enemy.takeDamage(STRENGTH);
    }

}
