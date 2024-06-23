package faang.school.godbless.kingsLandingTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        // Создание двух объектов класса Knight
        Knight knight1 = new Knight("KnightName1");
        Knight knight2 = new Knight("KnightName2");

        knight1.addTrial(new Trial(knight1.getName(), "Турнир на копьях"));
        knight1.addTrial(new Trial(knight2.getName(), "Бой на мечах"));

        knight2.addTrial(new Trial(knight1.getName(), "Турнир на копьях"));
        knight2.addTrial(new Trial(knight2.getName(), "Бой на мечах"));

        ExecutorService  executorService = Executors.newFixedThreadPool(2);

        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
    }
}
