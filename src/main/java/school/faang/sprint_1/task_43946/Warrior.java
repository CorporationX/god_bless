package school.faang.sprint_1.task_43946;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (!isAlive()) {
            return;
        }
        character.receiveDamage(STRENGTH);
        if (character.isAlive()) {
            System.out.println("У лучника " + character.getName() + " жизни осталось " + character.getHealth());
        } else {
            System.out.println("Лучник " + character.getName() + " мертв");
        }
    }
}
