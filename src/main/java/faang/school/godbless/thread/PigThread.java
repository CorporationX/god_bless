package faang.school.godbless.thread;

public class PigThread extends Thread {
    String name;
    Material material;

    public PigThread(String name, Material material) {
        this.name = name;
        this.material = material;
    }
}
