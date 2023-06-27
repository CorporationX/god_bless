package faang.school.godbless.game;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Naf-Naf", 3);
    }

    @Override
    public void run() {
        super.run();
        System.out.println(getPigName() + " cтроит дом из " + getMaterials());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " построил дом");
    }
}
