package school.faang.task_43842;

public class Warrior extends Character {
    private static final int INIT_STRENGTH = 10;
    private static final int INIT_AGILITY = 5;
    private static final int INIT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, INIT_STRENGTH, INIT_AGILITY, INIT_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        int damage = getStrength();
        target.decreaseHealth(damage);
        System.out.println(getName() + " (Warrior) attacked "
                + target.getName() + " and inflicts " + damage + " damage");
    }
}
