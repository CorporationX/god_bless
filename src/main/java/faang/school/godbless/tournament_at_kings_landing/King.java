package faang.school.godbless.tournament_at_kings_landing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knightFirst = new Knight("Brienna");
        Knight knightSecond = new Knight("Loras");

        knightFirst.addTrial(new Trial(knightFirst.getName(), "Забег 100 метров"));
        knightFirst.addTrial(new Trial(knightFirst.getName(), "Прыжки в длину"));

        knightSecond.addTrial(new Trial(knightSecond.getName(), "Подтягивания на турнике"));
        knightSecond.addTrial(new Trial(knightSecond.getName(), "Отжимания от пола"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(knightFirst::startTrials);
        executorService.submit(knightSecond::startTrials);

        executorService.shutdown();
    }
}
