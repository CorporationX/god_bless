package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(opponent.getHealth() - this.getStrength());
        } else {
            System.out.println("Opponent is already dead");
        }
    }
}
