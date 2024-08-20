package faang.school.godbless.threePigs;

public class Pig2Thread extends PigThread{
    public Pig2Thread() {
        super("Nuf-Nuf", "sticks");
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started building a house of " + this.getMaterial());
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getPigName()+ " finished building a house of " + this.getMaterial());
    }
}
