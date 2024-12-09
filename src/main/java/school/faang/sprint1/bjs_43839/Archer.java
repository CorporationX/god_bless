package school.faang.sprint1.bjs_43839;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int AGILITY = 7;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.receiveDamage(AGILITY);
    }
}
