package school.faang.bjs2_79351;

public class Archer extends Character {
    private static final int AGILITY_ARCHER = 10;
    private static final int INTELLECT_ARCHER = 5;
    private static final int STRENGTH_ARCHER = 3;

    public Archer(String name) {
        super(name);
        this.agility = AGILITY_ARCHER;
        this.strength = STRENGTH_ARCHER;
        this.intellect = INTELLECT_ARCHER;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }
}
