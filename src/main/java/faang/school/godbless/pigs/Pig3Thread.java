package faang.school.godbless.pigs;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Нуф-Нуф", "кирпич");
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строить из " + getMaterial());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getPigName() + " закончил строить из " + getMaterial());
    }
}
