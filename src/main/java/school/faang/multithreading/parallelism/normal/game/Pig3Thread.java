package school.faang.multithreading.parallelism.normal.game;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String name, Material material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse(material.getBuildTime());
    }
}
