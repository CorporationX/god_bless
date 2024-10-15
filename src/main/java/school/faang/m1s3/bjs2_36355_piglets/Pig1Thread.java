package school.faang.m1s3.bjs2_36355_piglets;

public class Pig1Thread extends PigThread{

    public Pig1Thread() {
        super("Niff-Niff", "Straw");
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " starts to build the house from " + getMaterial());
        System.out.println(getPigName() + " : It should take 2 days");

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getPigName() + " finished his " + getMaterial() + " house");
    }
}
