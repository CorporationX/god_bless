package faang.school.godbless.finallygoodgame2980.pigthreads;

public class Pig3Thread extends PigThread {

    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.printf("%s is building a house out of %ss%n", this.getPigName(), this.getMaterial());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s has built his house%n", this.getPigName());
    }
}
