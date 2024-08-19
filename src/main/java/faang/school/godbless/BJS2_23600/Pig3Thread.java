package faang.school.godbless.BJS2_23600;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Nif-Nif", 3);
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " строит дом из " + getMaterial() + "...");
            Thread.sleep(5000);
            System.out.println(this + " закончил строить дом из " + getMaterial() + ".");
        } catch (InterruptedException e) {
            System.out.println(this + " был прерван.");
        }
    }
}
