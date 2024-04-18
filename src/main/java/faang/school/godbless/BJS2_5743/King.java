package faang.school.godbless.BJS2_5743;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("George");
        Knight knight2 = new Knight("Eugen");

        knight1.addTrial(new Trial(knight1.getName(), "ездить на лошади"));
        knight1.addTrial(new Trial(knight1.getName(), "стрелять из лука"));
        knight2.addTrial(new Trial(knight2.getName(), "защищаться щитом"));
        knight2.addTrial(new Trial(knight2.getName(), "владеть мечем"));

        startTrials(List.of(knight1, knight2));
    }

    private static void startTrials(List<Knight> knights) {
        ExecutorService poolService = Executors.newFixedThreadPool(2);
        knights.stream().flatMap(knight -> knight.getTrials().stream()).forEach(poolService::submit);

        try {
            if (!poolService.awaitTermination(3500, TimeUnit.MILLISECONDS)) {
                poolService.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolService.shutdownNow();
        }
        System.out.println("Все испытания выполнены.");
    }
}
