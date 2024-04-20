package faang.school.godbless.pigs;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строительво дома из " + getMaterial());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " закончил строительво дома из " + getMaterial());
    }
}