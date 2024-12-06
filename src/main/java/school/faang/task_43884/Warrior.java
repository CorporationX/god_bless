package school.faang.task_43884;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() > 0) {
            character.setHealth(character.getHealth() - strength);
        } else {
            System.out.println("Противник убит!");
        }
    }
}