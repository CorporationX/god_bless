package school.faang;

public class Archer extends Character {
    private static final CharacterConfig CONFIG = new CharacterConfig(3, 10, 5);

    public Archer(String name) {
        super(name, 100, CONFIG.strength(), CONFIG.agility(), CONFIG.mind());
    }

    @Override
    protected void attack(Character target) {
        int damageToTarget = this.getAgility();
        System.out.printf("%s (Archer) attacks %s with %s damage (based on agility) ",
                this.getName(), target.getName(), damageToTarget);
        target.takeDamage(damageToTarget);
        System.out.printf("%s's health after attack: %s", target.getName(), target.getHealth());
    }
}
