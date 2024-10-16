package tourneyAtKingsLanding_35756;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private final static int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        Knight knightFirst = new Knight("Игорь");
        Knight knightSecond = new Knight("Вася");
        knightFirst.addTrial(new Trial(knightFirst.getName(), "съесть 100500 пельменей"));
        knightFirst.addTrial(new Trial(knightFirst.getName(), "спрыгнуть в доспехах с парашютом"));
        knightSecond.addTrial(new Trial(knightSecond.getName(), "переплыть озеро Байкал"));
        knightSecond.addTrial(new Trial(knightSecond.getName(), "достать царевну из лягушки"));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        knightFirst.startTrials(executor);
        knightSecond.startTrials(executor);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Испытания окончены");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
