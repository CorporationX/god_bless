package school.faang.task_58455;

public class Archer extends Character {

    private static final int START_ARCHER_STRENGTH = 5;
    private static final int START_ARCHER_AGILITY = 10;
    private static final int START_ARCHER_INTELLIGENCE = 3;

    public Archer(String name) {
        super(name, START_ARCHER_STRENGTH, START_ARCHER_AGILITY, START_ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        int newHealth = opponent.getHealth() - damage;
        opponent.setHealth(newHealth);
        System.out.printf("%s нанес %d урона, и оставил %s %d здоровья\n",
                this.getName(), damage, opponent.getName(), newHealth);
    }

}
