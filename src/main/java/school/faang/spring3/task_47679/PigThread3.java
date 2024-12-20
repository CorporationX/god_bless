package school.faang.spring3.task_47679;

public class PigThread3 extends PigThread {
    private static final int BUILD_TIME = 3000;

    public PigThread3(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse(BUILD_TIME);
    }
}
