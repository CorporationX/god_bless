package faang.school.godbless.FinallyGoodGame;

public abstract class PigThread extends Thread {
    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    public String getPigName() {
        return pigName;
    }

    public String getMaterial() {
        return material;
    }

    public void buildHouse() throws InterruptedException {
    }
}
