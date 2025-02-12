package school.faang.task_58455;

public class Warrior extends Character {
    private static final int START_WARRIOR_STRENGTH = 10;
    private static final int START_WARRIOR_AGILITY = 5;
    private static final int START_WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, START_WARRIOR_STRENGTH, START_WARRIOR_AGILITY, START_WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        int newHealth = opponent.getHealth() - damage;
        if (newHealth >= 0) {
            opponent.setHealth(newHealth);
            System.out.printf("%s нанес %d урона, и оставил %s(у) %d здоровья\n",
                    this.getName(), damage, opponent.getName(), opponent.getHealth());
        } else {
            System.out.printf("%s убил %s(а)\n", this.getName(), opponent.getName());
        }
    }
}
