package school.faang.bjs2_68184;

public class Archer extends Character {
    public static final int DEFAULT_STRENGTH = 3;
    public static final int DEFAULT_AGILITY = 10;
    public static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.getAgility());
    }
}