package school.faang.naughtwoBJS256522.character;

public class Archer extends Character {
    private final int defaultArcherStrengthValue = 3;
    private final int defaultArcherAgilityValue = 10;

    public Archer(String name) {
        super(name);
        setStrength(defaultArcherStrengthValue);
        setAgility(defaultArcherAgilityValue);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        super.attack(opponent);
    }
}
