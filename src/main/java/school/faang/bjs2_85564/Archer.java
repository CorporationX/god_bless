package school.faang.bjs2_85564;

public class Archer extends Character {
    public static final int STRENGTH = 3;
    public static final int AQILITY = 10;
    public static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AQILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (getHealth() == 0) {
            return;
        }
        System.out.printf("%s атакует %s ловкостью %d%n", getName(), opponent.getName(), getAgility());
        opponent.takeDamage(getAgility());
    }
}
