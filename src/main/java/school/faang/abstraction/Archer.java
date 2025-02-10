package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 5, 5, 5);
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        int archersAgility = getAgility();
        opponent.reduceHealth(archersAgility);
    }
}
