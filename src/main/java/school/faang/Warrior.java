package school.faang;

public class Warrior extends Character {

    public static final int POWER = 10;
    public static final int AGILITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.health -= power;
    }
}
