package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, GameProperties.ARCHER_DEFAULT_STRENGTH, GameProperties.ARCHER_DEFAULT_DEXTERITY,
                GameProperties.ARCHER_DEFAULT_INTELLECT);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.dexterity);
        setHealthPositive(opponent);
    }
}
