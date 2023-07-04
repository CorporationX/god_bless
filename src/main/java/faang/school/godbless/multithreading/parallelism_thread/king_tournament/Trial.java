package faang.school.godbless.multithreading.parallelism_thread.king_tournament;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private Long trialTime;

    public Trial(String knightName, String trialName, Long trialTime) {
        this.knightName = knightName;
        this.trialName = trialName;
        this.trialTime = trialTime;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + knightName + " начал выполнять испытание " + trialName);
        try {
            Thread.sleep(trialTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " " + knightName + " закончил выполнять испытание " + trialName);

    }
}
