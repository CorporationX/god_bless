package school.faang.sprint_3.task_47670;

public class FirstPigThread extends PigThread {
    private static final int CONSTRUCTION_DELAY = 5000;

    public FirstPigThread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s starts building %s house\n", getPigName(), getMaterial());
            Thread.sleep(CONSTRUCTION_DELAY);
            System.out.printf("%s ends building %s house\n", getPigName(), getMaterial());
        } catch (InterruptedException e) {
            System.out.printf("%s construction is interrupted\n", getPigName());
        }
    }
}
