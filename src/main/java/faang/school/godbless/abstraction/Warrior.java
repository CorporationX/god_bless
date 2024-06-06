package faang.school.godbless.abstraction;

public class Warrior extends Character {
    private static final int DEFAULT_WARRIOR_FORCE = 10;
    private static final int DEFAULT_WARRIOR_DEXTERITY = 5;
    private static final int DEFAULT_WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, DEFAULT_WARRIOR_FORCE, DEFAULT_WARRIOR_DEXTERITY, DEFAULT_WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        target.health -= this.force;
        System.out.println(this.name + " attack " + target.name + " and deals " + this.force + " damage");
    }
}
