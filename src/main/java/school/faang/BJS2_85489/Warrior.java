package school.faang.BJS2_85489;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10d;
        dexterity = 5d;
        intelligence = 3d;
    }

    @Override
    void attack(Character opponent) {
        if (opponent.isLive(strength)) {
            opponent.health -= strength;
        } else {
            opponent.health = 0;
        }
    }
}
