package dima.evseenko.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Джейме Ланнистер");
        Knight knight2 = new Knight("Лорес Тирелл");

        knight1.addTrial(new Trial(knight1.getName(), "Сражение с драконом"));
        knight1.addTrial(new Trial(knight1.getName(), "Поединок с великаном"));
        knight2.addTrial(new Trial(knight2.getName(), "Испытание верности"));
        knight2.addTrial(new Trial(knight2.getName(), "Битва за честь"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
    }
}
