package faang.school.godbless.BJS2_23600;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Naf-Naf", 2);
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " строит дом из " + getMaterial() + "...");
            Thread.sleep(3000);
            System.out.println(this + " закончил строить дом из " + getMaterial() + ".");
        } catch (InterruptedException e) {
            System.out.println(this + " был прерван.");
        }
    }
}
