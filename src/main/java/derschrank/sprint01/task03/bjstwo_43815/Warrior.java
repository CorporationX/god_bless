package derschrank.sprint01.task03.bjstwo_43815;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_DEXTERITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;


    public Warrior(String name) {
        super("Warrior", name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.receiveDamage(this.getStrength());
    }
}
