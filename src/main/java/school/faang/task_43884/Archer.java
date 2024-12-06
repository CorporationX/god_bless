package school.faang.task_43884;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 0) {
            character.setHealth(character.getHealth() - agility);
        } else {
            System.out.println("Противник убит!");
        }
    }
}