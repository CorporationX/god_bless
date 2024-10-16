package school.faang.multithreading.parallelism.normal.game;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String name, Material material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse(material.getBuildTime());
    }
}
