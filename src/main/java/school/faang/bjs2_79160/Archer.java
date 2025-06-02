package school.faang.bjs2_79160;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public void attack(Character opponent) {
        if (isMakeAttack(opponent.getHealth(), getAgility())) {
            int healthAfterDamage = opponent.getHealth() - getAgility();
            opponent.setHealth(healthAfterDamage);
        } else {
            System.out.println("Health" + getName() + " opponent is too low");
        }
    }
}
