package school.faang.bjs2_61228;

public class Mage extends Character {

    public Mage(int power) {
        super(power);
    }

    @Override
    public void attack() {
        System.out.printf("%s атакует с силой равной: %d %n", this, power);
    }
}
