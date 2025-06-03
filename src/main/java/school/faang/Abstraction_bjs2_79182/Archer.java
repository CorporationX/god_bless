package school.faang.Abstraction_bjs2_79182;

public class Archer extends Character {
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
        this.strength = ARCHER_STRENGTH;
        this.agility = ARCHER_AGILITY;
        this.intelligence = ARCHER_INTELLIGENCE;
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAgility());
        System.out.printf("Здоровье противника %s: %d\n", opponent.getName(), opponent.getHealth());
    }
}