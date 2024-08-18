package faang.school.godbless.thekingslandingtournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight rhaegar = new Knight("Rhaegar");
        Knight gregor = new Knight("Gregor");
        rhaegar.addTrial(new Trial(rhaegar.getName(), "Duel"));
        rhaegar.addTrial(new Trial(rhaegar.getName(), "Javelin tournament"));
        gregor.addTrial(new Trial(gregor.getName(), "Overcoming obstacles"));
        gregor.addTrial(new Trial(gregor.getName(), "Archery competition"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        rhaegar.startTrials(executorService);
        gregor.startTrials(executorService);
        executorService.shutdown();
    }
}