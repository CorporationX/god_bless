package school.faang.bjs2_69309;

public class Archer extends Character {

    final int power = 3;
    final int agility = 10;
    final int intelligence = 5;

    public Archer(String name) {
        super(name);
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(agility, opponent.health)) {
            opponent.health = opponent.health - agility;
        }
    }
}
