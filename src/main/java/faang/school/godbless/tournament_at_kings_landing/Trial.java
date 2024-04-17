package faang.school.godbless.tournament_at_kings_landing;

public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(knightName + " начинает выполнять испытание: " + trialName + " на потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(knightName + " не выполнил испытание: " + trialName);
            throw new RuntimeException(e);
        }
        System.out.println(knightName + " выполнил испытание: " + trialName + " на потоке " + Thread.currentThread().getName());
    }
}
