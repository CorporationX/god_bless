package school.faang.finallynormalgame;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    protected void buildHouse() throws InterruptedException {
        System.out.println(getPigName() + " is building a house with " + getMaterial() + ".");
        Thread.sleep(4000);
        System.out.println(getPigName() + " finished building a house with " + getMaterial() + ".");
    }
}
