package Finally_normal_game;

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
}
