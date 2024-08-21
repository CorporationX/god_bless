package faang.school.godbless.pigs;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "палки");
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строить из " + getMaterial());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getPigName() + " закончил строить из " + getMaterial());
    }
}
