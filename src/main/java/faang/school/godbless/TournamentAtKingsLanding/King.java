package faang.school.godbless.TournamentAtKingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight lancelot = new Knight("Lancelot");
        Knight tristan = new Knight("Tristan");

        lancelot.addTrial(new Trial(lancelot.getName(), "Поединок на конях"));
        lancelot.addTrial(new Trial(lancelot.getName(), "Конкурс гербов"));
        tristan.addTrial(new Trial(tristan.getName(), "Самый большой щит"));
        tristan.addTrial(new Trial(tristan.getName(), "Пеший поединок"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        lancelot.startTrials(executorService);
        tristan.startTrials(executorService);
        executorService.shutdown();
    }
}
