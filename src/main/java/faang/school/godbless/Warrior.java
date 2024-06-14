package faang.school.godbless;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_DEXTERITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_DEXTERITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        int damage = this.strength;
        target.health -= damage;
        System.out.println(this.name + " attacks " + target.name + " for " + damage + " damage.");
    }
}