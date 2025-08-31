package school.faang.BJS2_85489;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3d;
        dexterity = 10d;
        intelligence = 5d;
    }

    @Override
    void attack(Character opponent) {
        if (opponent.isLive(dexterity)) {
            opponent.health -= dexterity;
        } else {
            opponent.health = 0;
        }
    }
}
