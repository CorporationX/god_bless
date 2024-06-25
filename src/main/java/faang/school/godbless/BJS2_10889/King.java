package faang.school.godbless.BJS2_10889;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight sedrik = new Knight("Sedrik");
        Knight camelot = new Knight("Camelot");
        sedrik.addTrial(new Trial(sedrik.getName(), "пройти огненный ров"));
        sedrik.addTrial(new Trial(sedrik.getName(), "убить монстра"));
        camelot.addTrial(new Trial(camelot.getName(), "победить отряд пехоты"));
        camelot.addTrial(new Trial(camelot.getName(), "вытащить меч из камня"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        startTrials(sedrik, executorService);
        startTrials(camelot, executorService);

        executorService.shutdown();
        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) System.out.println("все испытания завершились");
    }

    private static void startTrials(Knight knight, ExecutorService executorService) {
        knight.getTrials().forEach(executorService::submit);
    }
}
