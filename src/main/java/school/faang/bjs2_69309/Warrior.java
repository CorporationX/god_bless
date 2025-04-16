package school.faang.bjs2_69309;

public class Warrior extends Character {

    public static final int POWER = 3;
    public static final int AGILITY = 10;
    public static final int INTELLIGENCE = 5;

    public Warrior(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(POWER, opponent.health)) {
            opponent.health = opponent.health - POWER;
        }
    }
}
