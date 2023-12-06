package faang.school.godbless;

public class Warrior extends Character{
    private static int STRENGTH = 10;
    private static int AGILITY = 5;
    private static int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth()-STRENGTH);
    }
}
