package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.intelligence = 5;
        this.strength = 10;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isAlive()) {
            opponent.setHealth(Math.max(opponent.getHealth() - this.getStrength(), 0));
        } else {
            System.out.println("Opponent is already dead");
        }
    }
}
