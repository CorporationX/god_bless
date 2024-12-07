package school.faang.task_43825;

public class Archer extends Character {
    private static final int DEFAULT_POWER = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_POWER, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);

    }

    @Override
    public void attack(Character target) {
        int damage = this.getAgility() * 2;

        target.takeDamage(damage);

        String targetClassName = target.getClass().getSimpleName();
        System.out.printf(
                "Archer %s deals %d damage to %s %s\n",
                this.getAgility(), damage, targetClassName.toLowerCase(), target.getName()
        );
    }

}
