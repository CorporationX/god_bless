package school.faang.bjs2_85564;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, Constants.WARRIOR_DEFAULT_STRENGTH,
                Constants.WARRIOR_DEFAULT_AGILITY,
                Constants.WARRIOR_DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s атакует %s с силой %d%n", getName(), opponent.getName(), getStrength());
        opponent.takeDamage(getStrength());
    }
}
