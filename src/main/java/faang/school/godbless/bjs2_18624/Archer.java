package faang.school.godbless.bjs2_18624;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(dexterity);
    }
}
