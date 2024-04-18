package faang.school.godbless.tournament_at_kings_landing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    private static final String FIRST_KNIGHT = "Brienna";
    private static final String SECOND_KNIGHT = "Loras";

    public static void main(String[] args) throws InterruptedException {

        Knight knightFirst = new Knight(FIRST_KNIGHT);
        Knight knightSecond = new Knight(SECOND_KNIGHT);

        knightFirst.addTrial(new Trial(FIRST_KNIGHT, "Забег 100 метров"));
        knightFirst.addTrial(new Trial(FIRST_KNIGHT, "Прыжки в длину"));

        knightSecond.addTrial(new Trial(SECOND_KNIGHT, "Подтягивания на турнике"));
        knightSecond.addTrial(new Trial(SECOND_KNIGHT, "Отжимания от пола"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(knightFirst::startTrials);
        executorService.submit(knightSecond::startTrials);

        Thread.sleep(10000);

        executorService.shutdown();
    }
}
