package faang.school.godbless.finallygoodgame2980.pigthreads;

public class Pig1Thread extends PigThread {

    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.printf("%s is building a house out of %ss%n", this.getPigName(), this.getMaterial());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s has built his house%n", this.getPigName());
    }

}
