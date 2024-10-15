package mightandmagic.army;

public class Recon extends Ship {
    public Recon(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "Разведчик (сила: " + getPower() + ")";
    }
}
