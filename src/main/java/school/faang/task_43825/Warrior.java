package school.faang.task_43825;

public class Warrior extends Character {
    private static final int DEFAULT_POWER = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_POWER, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        int damage = this.getPower() * 2;

        target.takeDamage(damage);

        String targetClassName = target.getClass().getSimpleName();
        System.out.printf(
                "Warrior %s deals %d damage to %s %s\n",
                this.getName(), damage, targetClassName.toLowerCase(), target.getName()
        );
    }

}
