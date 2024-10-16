package school.faang.multithreading.parallelism.normal.game;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String name, Material material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse(material.getBuildTime());
    }
}
