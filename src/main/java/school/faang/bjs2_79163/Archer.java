package school.faang.bjs2_79163;

public class Archer extends Character {
    public static final int DEFAULT_STRENGTH = 3;
    public static final int DEFAULT_AGILITY = 10;
    public static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
        strength = DEFAULT_STRENGTH;
        agility = DEFAULT_AGILITY;
        intelligence = DEFAULT_INTELLIGENCE;
    }

    @Override
    public void attack(Character defender) {
        System.out.println("Урон: " + agility);
        defender.reduceHealth(agility);
    }
}
