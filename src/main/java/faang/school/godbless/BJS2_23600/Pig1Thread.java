package faang.school.godbless.BJS2_23600;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Nuf-Nuf", 1);
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " строит дом из " + getMaterial() + "...");
            Thread.sleep(1000);
            System.out.println(this + " закончил строить дом из " + getMaterial() + ".");
        } catch (InterruptedException e) {
            System.out.println(this + " был прерван.");
        }
    }
}
