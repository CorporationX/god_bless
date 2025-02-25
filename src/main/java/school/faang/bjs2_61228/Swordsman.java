package school.faang.bjs2_61228;

public class Swordsman extends Character {

    public Swordsman(int power) {
        super(power);
    }

    @Override
    public void attack() {
        System.out.printf("%s атакует с силой равной: %d %n", this, power);
    }
}
