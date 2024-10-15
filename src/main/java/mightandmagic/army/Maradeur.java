package mightandmagic.army;

public class Maradeur extends Ship {
    public Maradeur(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "Марадёр (сила: " + getPower() + ")";
    }
}
