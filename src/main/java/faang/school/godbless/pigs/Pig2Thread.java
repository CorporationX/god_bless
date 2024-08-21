package faang.school.godbless.pigs;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Наф-Наф", "солома");
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строить из " + getMaterial());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getPigName() + " закончил строить из " + getMaterial());
    }
}
