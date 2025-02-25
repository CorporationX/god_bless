package school.faang.bjs2_61228;

public class Archer extends Character {

    public Archer(int power) {
        super(power);
    }

    @Override
    public void attack() {
        System.out.printf("%s атакует с силой равной: %d %n", this, power);
    }
}
