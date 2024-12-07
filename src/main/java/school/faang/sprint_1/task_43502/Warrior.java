package school.faang.sprint_1.task_43502;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character enemy) {
        if (checkIsAlive(enemy)) {
            enemy.setHealth(enemy.getHealth() - WARRIOR_STRENGTH);
            System.out.println(getName() + " атакует " + enemy.getName());
        }
    }
}
