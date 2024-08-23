package faang.school.godbless.BJS2_23361;

public class Pig3Thread extends PigThread {

    private static final String pigName = "Наф-Наф";
    private static final String material = "bricks";

    public Pig3Thread() {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " started  building a house out of " + getMaterial());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The house of " + getMaterial() + " is built");
    }
}