package school.faang.bjs2_79157;

public class Warrior extends Character {
    private static final int STARTER_STRENGTH = 10;
    private static final int STARTER_AGILITY = 5;
    private static final int STARTER_INTELLIGENCE = 3;


    public Warrior(String name) {
        super(name);
        this.strength = STARTER_STRENGTH;
        this.agility = STARTER_AGILITY;
        this.intelligence = STARTER_INTELLIGENCE;
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("🗡 " + this.getName() + " attacks️ " + opponent.getName());
        opponent.takeDamage(this.getStrength());
    }
}
