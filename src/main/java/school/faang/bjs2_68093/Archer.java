package school.faang.bjs2_68093;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    void attack(Character opponent) {
        opponent.reduceHealth(this.agility);
    }
}
