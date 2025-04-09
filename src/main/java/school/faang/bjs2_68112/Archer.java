package school.faang.bjs2_68112;

public class Archer extends Character {
    private static final Integer DEFAULT_STRENGTH = 3;
    private static final Integer DEFAULT_AGILITY = 10;
    private static final Integer DEFAULT_INTELLECT = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLECT);
    }

    public Archer(String name, Integer strength, Integer agility, Integer intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character opponent) {
        opponent.diminishHealth(this.getAgility());
    }
}
