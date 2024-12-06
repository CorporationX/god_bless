package derschrank.task03.bjstwo_43815;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_DEXTERITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;


    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
        type = "Warrior";
    }

    @Override
    public void attack(Character character) {
        character.getDamage(this.getStrength());
    }
}
