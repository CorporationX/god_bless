package faang.school.godbless.threePigs;

public class Pig1Thread extends PigThread{

    public Pig1Thread() {
        super("Nif-Nif", "straw");
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started building a house of " + this.getMaterial());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getPigName() + " finished building a house of " + this.getMaterial());
    }
}
