package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(opponent.getHealth() - this.getAgility());
        } else {
            System.out.println("Opponent is already dead");
        }
    }
}
