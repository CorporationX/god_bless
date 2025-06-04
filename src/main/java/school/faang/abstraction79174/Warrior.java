package school.faang.abstraction79174;


public class Warrior extends Character {
    private static final int POWER = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, POWER, DEXTERITY, INTELLIGENCE);
    }

    public void attack(Character opponent) {
        opponent.health -= this.power;
        checkHealth(opponent);
    }
}
