package school.faang.bjs2_79157;

public class Warrior extends Character {
    private static final int STARTER_STRENGTH = 10;
    private static final int STARTER_DEXTERITY = 5;
    private static final int STARTER_INTELLIGENCE = 3;


    public Warrior(String name) {
        super(name);
        this.strength = STARTER_STRENGTH;
        this.dexterity = STARTER_DEXTERITY;
        this.intelligence = STARTER_INTELLIGENCE;
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("🗡 " + this.getName() + " attacks️ " + opponent.getName());
        opponent.takeDamage(this.getStrength());
    }
}
