package school.faang.BJS2_85677;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntellect(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
        healthLevelChecking(opponent);
    }
}
