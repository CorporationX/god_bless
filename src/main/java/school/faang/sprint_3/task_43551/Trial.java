package school.faang.sprint_3.task_43551;

public record Trial(String knightName, String trialName) implements Runnable {
    private static final int SLEEP_TIME = 3000;

    @Override
    public void run() {
        System.out.println(knightName + " начинает испытание: " + trialName);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println(knightName + " прервал выполнение испытания: " + trialName);
        }
        System.out.println(knightName + " завершил испытание: " + trialName);
    }
}
