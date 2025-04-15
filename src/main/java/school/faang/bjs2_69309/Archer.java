package school.faang.bjs2_69309;

public class Archer extends Character {

    private static final int power = 3;
    private static final int agility = 10;
    private static final int intelligence = 5;

    public Archer(String name) {
        super(name, power, agility, intelligence);
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(agility, opponent.health)) {
            opponent.health = opponent.health - agility;
        }
    }
}
