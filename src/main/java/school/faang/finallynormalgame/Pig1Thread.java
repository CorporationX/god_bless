package school.faang.finallynormalgame;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    protected void buildHouse() throws InterruptedException {
        System.out.println(getPigName() + " is building a house with " + getMaterial() + ".");
        Thread.sleep(2000);
        System.out.println(getPigName() + " finished building a house with " + getMaterial() + ".");
    }
}