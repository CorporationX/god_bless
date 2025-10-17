package school.faang.BJS2_85677;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntellect(5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        healthLevelChecking(opponent);
    }
}
