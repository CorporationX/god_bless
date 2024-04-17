package Multithreading_ArmyOfTheHeroes;

public class Mage extends Character {
    public Mage(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return true;
    }
}
