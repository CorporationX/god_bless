package Multithreading_ArmyOfTheHeroes;

public class Archer extends Character {
    public Archer(int power) {
        super(power);
    }

    @Override
    public boolean isArcher() {
        return true;
    }
}
