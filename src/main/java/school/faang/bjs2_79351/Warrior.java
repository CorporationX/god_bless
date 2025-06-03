package school.faang.bjs2_79351;

public class Warrior extends Character {
    private static final int AGILITY_WARRIOR = 5;
    private static final int INTELLECT_WARRIOR = 3;
    private static final int STRENGTH_WARRIOR = 10;

    public Warrior(String name) {
        super(name);
        this.agility = AGILITY_WARRIOR;
        this.strength = STRENGTH_WARRIOR;
        this.intellect = INTELLECT_WARRIOR;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }
}