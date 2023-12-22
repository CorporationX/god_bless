package faang.school.godbless.multithreading_parallelism.army_of_heroes_of_might_and_magic;


public abstract class Unit {

    private int power;

    public Unit(int power) {
        this.power = power;
    }


    protected boolean isMage() {
        return false;
    }

    protected boolean isSwordsman() {
        return false;
    }

    protected boolean isArcher() {
        return false;
    }


    public int getPower() {
        return power;
    }
}
