package school.faang.distributed_army;

public class Archer extends Hero {
    public Archer() {
        super(25);
    }

    @Override
    public void attack() {
        System.out.println("Archer attacks with power + " + power);
    }
}
