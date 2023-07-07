package faang.school.godbless.normalGame;

public class PigThread extends Thread{
    private String pigName;
    private int material;

    public PigThread(String pigName, int material) {
        this.pigName = pigName;
        this.material = material;
    }

    public String getPigName() {
        return pigName;
    }

    public int getMaterial() {
        return material;
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " started building a house from " + getMaterial());
            Thread.sleep(1000);
            System.out.println(getPigName() + " built a house out of " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
