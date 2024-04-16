package faang.school.godbless.bjs2_5582;

public class Pig3Thread extends PigThread {

    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println(getPigName() + " построил дом из " + getMaterial());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
