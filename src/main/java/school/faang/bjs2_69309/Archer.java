package school.faang.bjs2_69309;

public class Archer extends Character {

    private static final int POWER = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(AGILITY, opponent.health)) {
            opponent.health = opponent.health - AGILITY;
        }
    }
}
