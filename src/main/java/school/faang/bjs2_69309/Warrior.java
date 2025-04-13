package school.faang.bjs2_69309;

public class Warrior extends Character {

    final int power = 10;
    final int agility = 5;
    final int intelligence = 3;

    public Warrior(String name) {
        super(name);
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(power, opponent.health)) {
            opponent.health = opponent.health - power;
        }
    }
}
