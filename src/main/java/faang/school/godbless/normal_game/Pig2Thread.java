package faang.school.godbless.normal_game;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        buildHouse();
    }

    private void buildHouse() {
        while (material >= 1) {
            constructOneMaterial();
        }
    }

    private void constructOneMaterial() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException("The Wolf Came and destroyed everything");
        }
        material--;
        System.out.println(pigName + " has made one step: one stick was constructed to house");
    }
}