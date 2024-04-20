package faang.school.godbless.pigs;

public class Pig1Thread extends PigThread{
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строительво дома из " + getMaterial());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " закончил строительво дома из " + getMaterial());
    }
}
