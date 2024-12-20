package school.faang.spring3.task_47679;

public class PigThread2 extends PigThread {
    private static final int BUILD_TIME = 2000;

    public PigThread2(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse(BUILD_TIME);
    }
}
