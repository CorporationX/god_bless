package mightandmagic.army;

public class Cruiser extends Ship {
    public Cruiser(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "Крейсер (сила: " + getPower() + ")";
    }
}
