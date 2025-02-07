package school.faang.naughtwoBJS256522.character;

public class Archer extends Character {
    private final int DEFAULT_ARCHER_STRENGTH_VALUE = 3;
    private final int DEFAULT_ARCHER_AGILITY_VALUE = 10;

    public Archer(String name) {
        super(name);
        setStrength(DEFAULT_ARCHER_STRENGTH_VALUE);
        setAgility(DEFAULT_ARCHER_AGILITY_VALUE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        super.attack(opponent);
    }
}
