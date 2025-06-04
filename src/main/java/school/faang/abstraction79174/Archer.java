package school.faang.abstraction79174;

public class Archer extends Character {
    private static final int POWER = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, POWER, DEXTERITY, INTELLIGENCE);
    }

    public void attack(Character opponent) {
        opponent.health -= this.getDexterity();
        checkHealth(opponent);
    }
}
