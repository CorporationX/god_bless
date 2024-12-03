package school.faang.abstraction_abstraction;

public class Warrior extends Character {
    private static final int POWER = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, POWER, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.getName() + " Warrior atacked " + opponent.getName());
        opponent.takeDamage(POWER);
        System.out.println(opponent.getName() + " now has " + opponent.getHealth() + " health.");
    }
}
