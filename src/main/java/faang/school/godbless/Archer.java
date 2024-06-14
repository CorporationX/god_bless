package faang.school.godbless;

public class Archer extends Character {
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_DEXTERITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_DEXTERITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        int damage = this.dexterity;
        target.health -= damage;
        System.out.println(this.name + " shoots " + target.name + " for " + damage + " damage.");
    }
}