package BJS2_56427;

public class Archer extends Character {
    public Archer(String name, int att, int dex, int intel) {
        super(name, att, dex, intel);
    }

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getAgility());
        checkHealth();
    }
}
