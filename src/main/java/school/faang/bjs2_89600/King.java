package school.faang.bjs2_89600;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    @SuppressWarnings({"checkstyle:AbbreviationAsWordInName", "checkstyle:VariableDeclarationUsageDistance"})
    public static void main(String[] args) {
        final int THREAD_AMOUNT = 2;
        final long ALL_TRIALS_TIME = 4;
        Knight senya = new Knight("Сеня Лютый");
        Knight petya = new Knight("Петя Мясник");
        Trial trial1 = new Trial(senya.getName(), "остановить коня на скаку.");
        Trial trial2 = new Trial(senya.getName(), "привезти царицыны черевички.");
        Trial trial3 = new Trial(petya.getName(), "войти в горящую избу.");
        Trial trial4 = new Trial(petya.getName(), "принести 4 головы змея Горыныча.");

        senya.addTrial(trial1);
        senya.addTrial(trial2);
        petya.addTrial(trial3);
        petya.addTrial(trial4);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        senya.startTrials(executor);
        petya.startTrials(executor);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(ALL_TRIALS_TIME, TimeUnit.MINUTES)) {
                System.out.println("Публика устала ждать обоих рыцарей, все разошлись по домам.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Подошло время обеда, всем пришлось прерваться на обед.");
        }
    }
}
