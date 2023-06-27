package faang.school.godbless.FinallyGoodGame;

public class Pig2Thread extends PigThread{
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    public void buildHouse() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Building " + this.getMaterial() + " house");
    }
}
