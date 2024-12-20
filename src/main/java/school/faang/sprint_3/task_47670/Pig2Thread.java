package school.faang.sprint_3.task_47670;

public class Pig2Thread extends PigThread {
    private static final int constructionDelay = 3000;

    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s starts building %s house\n", getPigName(), getMaterial());
            Thread.sleep(constructionDelay);
            System.out.printf("%s ends building %s house\n", getPigName(), getMaterial());
        } catch (InterruptedException e) {
            System.out.printf("%s construction is interrupted\n", getPigName());
        }
    }
}