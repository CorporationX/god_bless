package school.faang.sprint3.distributedarmy;

public abstract class Unit {

    private int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public boolean isMage() {
        return false;
    }

    public boolean isSwordsman() {
        return false;
    }

    public boolean isArcher() {
        return false;
    }

}
