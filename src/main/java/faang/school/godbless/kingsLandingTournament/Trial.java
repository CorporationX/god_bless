package faang.school.godbless.kingsLandingTournament;

public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " начинает выполнение испытания " + trialName + " для рыцаря " + knightName);
            Thread.sleep((int)Math.random() * 3000);
            System.out.println(threadName + " завершил выполнение испытания " + trialName + " для рыцаря " + knightName);
        } catch (InterruptedException e) {
            System.err.println("Испытание " + trialName + " для рыцаря " + knightName + " было прервано.");
        }
    }
}
