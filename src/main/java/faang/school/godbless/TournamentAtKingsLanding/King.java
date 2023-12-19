package faang.school.godbless.TournamentAtKingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight lancelot = new Knight("Lancelot");
        Knight tristan = new Knight("Tristan");

        Knight.addTrial(new Trial(lancelot.getName(), "Поединок на конях"));
        Knight.addTrial(new Trial(lancelot.getName(), "Конкурс гербов"));
        Knight.addTrial(new Trial(tristan.getName(), "Самый большой щит"));
        Knight.addTrial(new Trial(tristan.getName(), "Пеший поединок"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Knight.startTrials(executorService);
        executorService.shutdown();
    }
}
