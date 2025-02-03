package school.faang.task_56329;

public class Archer extends Character {
    private static int DEFAULT_STRENGTH = 3;
    private static int DEFAULT_AGILITY = 10;
    private static int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
        setStrength(DEFAULT_STRENGTH);
        setAgility(DEFAULT_AGILITY);
        setIntelligence(DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " attacks " + opponent.getName() + " for " + getAgility() + " damage");
        attackDamage(getAgility());
    }
}
