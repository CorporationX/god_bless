package school.faang;

public class Warrior extends Character{
    private static final int power = 10;
    private static final int agility = 5;
    private static final int intelligence = 3;

    public Warrior(String name) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
