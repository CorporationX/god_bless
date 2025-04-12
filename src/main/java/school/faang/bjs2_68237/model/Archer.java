package school.faang.bjs2_68237.model;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.agility;
        opponent.checkHealth();
    }
}