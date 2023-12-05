package faang.school.godbless.multithreading.parallelism_thread.normal_game;

public class PigThread extends Thread {
    private String pigName;
    private MaterialEnum material;

    public PigThread(String pigName, MaterialEnum material) {
        this.pigName = pigName;
        this.material = material;
    }

    public String getPigName() {
        return pigName;
    }

    public Material getMaterial() {
        return material.getMaterial();
    }
}
