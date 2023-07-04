package faang.school.godbless.FinallyGoodGame;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName) {
        super(pigName, "bricks");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Building " + this.getMaterial() + " house");
    }
}
