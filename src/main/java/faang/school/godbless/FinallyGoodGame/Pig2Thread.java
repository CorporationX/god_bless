package faang.school.godbless.FinallyGoodGame;

public class Pig2Thread extends PigThread{
    public Pig2Thread(String pigName) {
        super(pigName, "sticks");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Building " + this.getMaterial() + " house");
    }
}
