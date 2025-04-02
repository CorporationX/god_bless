package school.faang.distributed_army;

public class Swordsman extends Hero {
    public Swordsman() {
        super(30);
    }

    @Override
    public void attack() {
        System.out.println("Swordsman attacks with power + " + power);
    }
}
