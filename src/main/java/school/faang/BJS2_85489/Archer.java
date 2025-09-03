package school.faang.BJS2_85489;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3d, 10d, 5d);
    }

    @Override
    void attack(Character opponent) {
        opponent.decrementHealth(getDexterity());
    }
}
