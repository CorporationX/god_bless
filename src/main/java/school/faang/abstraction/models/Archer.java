package school.faang.abstraction.models;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        reduceHealth(opponent, getAgility());
    }
}
