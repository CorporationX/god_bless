package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        power = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(agility, opponent.health)) {
            opponent.health = opponent.health - agility;
        }
    }
}
