package BJS2_56427;

public class Warrior extends Character {
    public Warrior(String name, int att, int dex, int intel) {
        super(name, att, dex, intel);
    }

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
        checkHealth();
    }
}
