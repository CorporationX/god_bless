package school.faang;

public class Archer extends Character {
    private static final int STRANGE = 3;
    private static final int AGILITY = 10;
    private static final int MIND = 5;

    public Archer(String name) {
        super(name, STRANGE, AGILITY, MIND);
    }

    @Override
    protected void attack(Character target) {
        int damage = this.agility;
        System.out.printf("%s (Archer) attack %s qith %d damage (based on agility)%n",
                this.name, target.getName(), damage);
        target.takeDamage(damage);
        System.out.printf("%s's health after attack: %d%n", target.getName(), target.getHealth());
    }
}
