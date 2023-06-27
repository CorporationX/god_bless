package faang.school.godbless.FinallyGoodGame;

public class Pig1Thread extends PigThread{
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    public void buildHouse() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Building " + this.getMaterial() + " house");
    }
}
