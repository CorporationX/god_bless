package school.faang.abstraction_abstraction;

public class Archer extends Character {
    private static final int POWER = 3;
    private static final int DEXTIRITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, POWER, DEXTIRITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.getName() + " (Archer) attacks " + opponent.getName());
        opponent.takeDamage(DEXTIRITY);
        System.out.println(opponent.getName() + " now has " + opponent.getHealth() + " health.");
    }
}
