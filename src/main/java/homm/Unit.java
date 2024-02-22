package homm;

public abstract class Unit {
    private int power;

    public Unit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String toString(){
        return String.valueOf(power);
    }
}
