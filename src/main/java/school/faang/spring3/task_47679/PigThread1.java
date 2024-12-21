package school.faang.spring3.task_47679;

public class PigThread1 extends PigThread {
    private static final int BUILD_TIME = 1000;

    public PigThread1(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse(BUILD_TIME);
    }


}
