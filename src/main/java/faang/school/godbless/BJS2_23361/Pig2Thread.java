package faang.school.godbless.BJS2_23361;

public class Pig2Thread extends PigThread {

    private static final String pigName = "Нуф-Нуф";
    private static final String material = "sticks";

    public Pig2Thread() {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " started  building a house out of " + getMaterial());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The house of " + getMaterial() + " is built");
    }
}