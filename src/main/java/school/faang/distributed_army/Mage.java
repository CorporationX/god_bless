package school.faang.distributed_army;

public class Mage extends Hero {
    public Mage() {
        super(50);
    }

    @Override
    public void attack() {
        System.out.println("Mage attacks with power + " + power);
    }
}
