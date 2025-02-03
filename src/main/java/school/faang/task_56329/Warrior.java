package school.faang.task_56329;

public class Warrior extends Character {
    private static int DEFAULT_STRENGTH = 10;
    private static int DEFAULT_AGILITY = 5;
    private static int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        setStrength(DEFAULT_STRENGTH);
        setAgility(DEFAULT_AGILITY);
        setIntelligence(DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " attacks " + opponent.getName()
                + " for " + getStrength() + " damage");
        attackDamage(getStrength());
    }
}
