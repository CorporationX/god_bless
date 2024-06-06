package faang.school.godbless.abstraction;

public class Archer extends Character {
    private static final int DEFAULT_ARCHER_FORCE = 3;
    private static final int DEFAULT_ARCHER_DEXTERITY = 10;
    private static final int DEFAULT_ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_ARCHER_FORCE, DEFAULT_ARCHER_DEXTERITY, DEFAULT_ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        target.health -= this.dexterity;
        System.out.println(this.name + " attack " + target.name + " and deals " + this.force + " damage");
    }
}
