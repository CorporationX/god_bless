package school.faang;

public class PigThread extends Thread {
    private final String pigName;
    public final String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }
}
