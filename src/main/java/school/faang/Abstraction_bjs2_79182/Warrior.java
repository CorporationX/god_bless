package school.faang.Abstraction_bjs2_79182;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name);
        this.strength = WARRIOR_STRENGTH;
        this.agility = WARRIOR_AGILITY;
        this.intelligence = WARRIOR_INTELLIGENCE;
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
        System.out.printf("Здоровье противника %s: %d\n", opponent.getName(), opponent.getHealth());
    }
}
