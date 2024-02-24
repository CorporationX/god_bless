package faang.school.godbless.finallygoodgame2980.pigthreads;

public class Pig2Thread extends PigThread {

    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.printf("%s is building a house out of %ss%n", this.getPigName(), this.getMaterial());
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s has built his house%n", this.getPigName());
    }

}
