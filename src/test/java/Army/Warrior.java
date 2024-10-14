package Army;

public abstract class Warrior {
    protected int power;

    public Warrior(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
