package school.faang.bjs2_79163;

public class Warrior extends Character {
    public static final int DEFAULT_STRENGTH = 10;
    public static final int DEFAULT_AGILITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        strength = DEFAULT_STRENGTH;
        agility = DEFAULT_AGILITY;
        intelligence = DEFAULT_INTELLIGENCE;
    }

    @Override
    public void attack(Character defender) {
        System.out.printf(GameMessage.DAMAGE.format(strength) + "\n");
        defender.reduceHealth(strength);
    }
}
