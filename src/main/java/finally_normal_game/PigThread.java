package finally_normal_game;

public class PigThread extends Thread {
    private String pigName;
    private int material;

    public String getPigName() {
        return pigName;
    }

    public int getMaterial() {
        return material;
    }

    public PigThread(String pigName, int material){
        this.pigName = pigName;
        this.material = material;
    }
    public void run() {
        System.out.println(getPigName() +
                " starts to build a house out of material - " + getMaterial());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " finished.");
    }
}
