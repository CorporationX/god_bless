package school.faang.m1s3.bjs2_36355_piglets;

public class Pig2Thread extends PigThread{

    public Pig2Thread() {
        super("Naff-Naff", "Wood");
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " starts to build the house from " + getMaterial());
        System.out.println(getPigName() + " : It should take 5 days");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("3 моre days left for " + getPigName() + " to build his " + getMaterial() + " house");

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getPigName() + " finished his " + getMaterial() + " house");
    }
}
