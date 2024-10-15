package mightandmagic.army;

public class Frigate extends Ship {
    public Frigate(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "Фрегат (сила: " + getPower() + ")";
    }
}
