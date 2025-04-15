package school.faang.bjs2_69309;

public class Warrior extends Character {

    public static final int power = 3;
    public static final int agility = 10;
    public static final int intelligence = 5;

    public Warrior(String name) {
        super(name, power, agility, intelligence);
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(power, opponent.health)) {
            opponent.health = opponent.health - power;
        }
    }
}
