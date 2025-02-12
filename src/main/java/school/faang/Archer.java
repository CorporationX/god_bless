package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.intelligence = 5;
        this.strength = 3;
        this.agility = 10;
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(Math.max(opponent.getHealth() - this.getAgility(), 0));
        } else {
            System.out.println("Opponent is already dead");
        }
    }
}
