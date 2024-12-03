package school.faang;

public class Warrior extends Character {
    private static final int STRANGE = 10;
    private static final int AGILITY = 5;
    private static final int MIND = 3;

    public Warrior(String name) {
        super(name, STRANGE, AGILITY, MIND);
    }

    @Override
    protected void attack(Character target) {
        int damage = this.strange;
        System.out.printf("%s (Warrior) attack %s qith %d damage (based on strength)%n",
                this.name, target.getName(), damage);
        target.takeDamage(damage);
        System.out.printf("%s's health after attack: %d%n", target.getName(), target.getHealth());
    }
}
