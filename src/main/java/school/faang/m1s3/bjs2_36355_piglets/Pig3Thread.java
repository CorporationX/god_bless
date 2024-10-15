package school.faang.m1s3.bjs2_36355_piglets;

public class Pig3Thread extends PigThread{

    public Pig3Thread() {
        super("Nuff-Nuff", "Stone");
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " starts to build the house from " + getMaterial());
        System.out.println(getPigName() + " : It should take 10 days");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getPigName() + " finished basement. 8 days left");

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getPigName() + " finished walls. 5 days left");

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("2 моre days left for " + getPigName() + " to build his " + getMaterial() + " house");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getPigName() + " finished his " + getMaterial() + " house");
    }
}
