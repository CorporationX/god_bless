package faang.school.godbless.FinallyGoodGame;

public class Pig1Thread extends PigThread{
    public Pig1Thread(String pigName) {
        super(pigName, "straw");
    }
    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Building " + this.getMaterial() + " house");
    }
}
