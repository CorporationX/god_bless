package school.faang.bjs2_85564;

public class Archer extends Character {
    public Archer(String name) {
        super(name, Constants.ARCHER_DEFAULT_STRENGTH,
                Constants.ARCHER_DEFAULT_AGILITY,
                Constants.ARCHER_DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s атакует %s ловкостью %d%n", getName(), opponent.getName(), getAgility());
        opponent.takeDamage(getAgility());
    }


}
