package school.faang.BJS2_85489;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10d, 5d, 3d);
    }

    @Override
    void attack(Character opponent) {
        opponent.decrementHealth(getStrength());
    }
}
