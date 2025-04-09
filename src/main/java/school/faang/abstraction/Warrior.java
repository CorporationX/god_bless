package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, GameProperties.WARRIOR_DEFAULT_STRENGTH, GameProperties.WARRIOR_DEFAULT_DEXTERITY,
                GameProperties.WARRIOR_DEFAULT_INTELLECT);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.strength);
        setHealthPositive(opponent);
    }
}
