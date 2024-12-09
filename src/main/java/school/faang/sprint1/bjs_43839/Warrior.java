package school.faang.sprint1.bjs_43839;

public class Warrior extends Character {
    private static final int STRENGTH = 18;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.receiveDamage(STRENGTH);
    }
}
