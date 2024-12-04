package school.faang;

public class Warrior extends Character {
    private static final CharacterConfig CONFIG = new CharacterConfig(10, 5, 3);

    public Warrior(String name) {
        super(name, 100, CONFIG.strength(), CONFIG.agility(), CONFIG.mind());
    }

    @Override
    protected void attack(Character target) {
        int damageToTarget = this.getStrength();
        System.out.printf("%s (Warrior) attacks %s with %s damage (based on strength)%n",
                this.getName(), target.getName(), damageToTarget);
        target.takeDamage(damageToTarget);
        System.out.printf("%s's health after attack: %s %n", target.getName(), target.getHealth());
    }
}
