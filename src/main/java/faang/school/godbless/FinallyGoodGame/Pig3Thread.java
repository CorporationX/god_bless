package faang.school.godbless.FinallyGoodGame;

public class Pig3Thread extends PigThread {

    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    public void buildHouse() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Building " + this.getMaterial() + " house");
    }
}
