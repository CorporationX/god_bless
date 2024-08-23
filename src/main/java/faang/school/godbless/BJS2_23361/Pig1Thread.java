package faang.school.godbless.BJS2_23361;

public class Pig1Thread extends PigThread {

    private static final String pigName = "Ниф-Ниф";
    private static final String material = "straw";

    public Pig1Thread() {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " started  building a house out of " + getMaterial());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The house of " + getMaterial() + " is built");
    }
}
