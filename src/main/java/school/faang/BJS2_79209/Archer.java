package school.faang.BJS2_79209;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int agility, int intellect) {
        super(name, strength, agility, intellect);
    }

    @Override
    public void attack(Character opponent) {
        int hitPoints = 0;
        if (checkHitPoints(opponent, agility)) {
            hitPoints = opponent.health - agility;
        }

        opponent.health = hitPoints;
    }
}
