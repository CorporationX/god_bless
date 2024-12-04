package school.faang.sprint1.bjs_43839;

public class Warrior extends Character {
    public static final int STRENGTH = 10;
    public static final int AGILITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.health -= STRENGTH;
    }
}
