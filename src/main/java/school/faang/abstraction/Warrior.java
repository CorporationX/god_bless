package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}

