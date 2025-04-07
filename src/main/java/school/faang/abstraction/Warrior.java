package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}
