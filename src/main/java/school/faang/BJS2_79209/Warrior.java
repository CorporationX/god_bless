package school.faang.BJS2_79209;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public Warrior(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character opponent) {
        int hitPoints = 0;
        if (checkHitPoints(opponent, strength)) {
            hitPoints = opponent.health - strength;
        }

        opponent.health = hitPoints;
    }
}
