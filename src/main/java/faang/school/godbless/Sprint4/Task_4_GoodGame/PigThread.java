package faang.school.godbless.Sprint4.Task_4_GoodGame;

public class PigThread extends Thread {
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
}
