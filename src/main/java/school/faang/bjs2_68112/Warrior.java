package school.faang.bjs2_68112;

public class Warrior extends Character {
    private static final Integer DEFAULT_STRENGTH = 10;
    private static final Integer DEFAULT_AGILITY = 5;
    private static final Integer DEFAULT_INTELLECT = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLECT);
    }

    public Warrior(String name, Integer strength, Integer agility, Integer intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character opponent) {
        opponent.diminishHealth(this.getStrength());
    }
}
