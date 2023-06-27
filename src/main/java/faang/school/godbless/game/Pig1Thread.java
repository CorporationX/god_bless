package faang.school.godbless.game;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Nif-Nif", 1);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " cтроит дом из " + getMaterials());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " построил дом");
    }
}
