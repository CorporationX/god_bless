package school.faang.sprint_1.task_43946;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (!isAlive()) {
            return;
        }
        character.receiveDamage(AGILITY);
        if (character.isAlive()) {
            System.out.println("У воина " + character.getName() + " жизни осталось " + character.getHealth());
        } else {
            System.out.println("Воин " + character.getName() + " мертв");
        }
    }
}
