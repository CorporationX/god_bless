package school.faang.BJS2_79229;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - agility);
        opponent.checkZeroHealth();
    }
}
