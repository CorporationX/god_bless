package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        power = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    void attack(Character opponent) {
        if (healthCheck(power, opponent.health))
            opponent.health = opponent.health - power;
    }
}
