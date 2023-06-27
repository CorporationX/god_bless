package faang.school.godbless.game;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Nuf-Nuf", 2);
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
