package derschrank.sprint01.task03.bjstwo_43815;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super("Archer", name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.receiveDamage(this.getDexterity());
    }
}
