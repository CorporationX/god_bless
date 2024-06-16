package faang.school.godbless.TheKingTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Luter");
        knight1.addTrial(new Trial("Luter", "Вопрос ребром"));
        knight1.addTrial(new Trial("Luter", "Что Было Дальше?"));

        Knight knight2 = new Knight("Gabriel");
        knight2.addTrial(new Trial("Gabriel", "Скакалка"));
        knight2.addTrial(new Trial("Gabriel", "Чесалка"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(knight1::startTrials);
        executorService.submit(knight2::startTrials);
        executorService.shutdown();

    }
}
