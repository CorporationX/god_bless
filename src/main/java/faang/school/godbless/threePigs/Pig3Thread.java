package faang.school.godbless.threePigs;

public class Pig3Thread extends PigThread {

    public Pig3Thread() {
        super("Naf-Naf", "bricks");
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started building a house of " + this.getMaterial());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getPigName() + " finished building a house of " + this.getMaterial());
    }
}
