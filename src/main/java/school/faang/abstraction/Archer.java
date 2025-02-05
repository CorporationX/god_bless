package school.faang.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
    }
}

