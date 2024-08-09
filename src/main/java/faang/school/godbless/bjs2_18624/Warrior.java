package faang.school.godbless.bjs2_18624;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.reduceHealth(power);
    }
}
