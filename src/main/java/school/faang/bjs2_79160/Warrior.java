package school.faang.bjs2_79160;

public class Warrior extends Character {
    private static final int DEFAULT_STRENGTH = 10;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public void attack(Character opponent) {
        if (isMakeAttack(opponent.getHealth(), getStrength())) {
            int healthAfterDamage = opponent.getHealth() - getStrength();
            opponent.setHealth(healthAfterDamage);
        } else {
            opponent.setHealth(0);
            System.out.println("Health " + opponent.getName() + " is too low ");
        }
    }

}
