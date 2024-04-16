package faang.school.godbless.bjs2_5582;

public class Pig1Thread extends PigThread {

    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(getPigName() + " построил дом из " + getMaterial());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
