package faang.school.godbless.BJS2_23494;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Max");
        knight1.addTrial(new Trial(knight1.getName(), "Дуэль"));
        knight1.addTrial(new Trial(knight1.getName(), "Забег на время"));

        Knight knight2 = new Knight("Elon");
        knight2.addTrial(new Trial(knight2.getName(), "Дуэль"));
        knight2.addTrial(new Trial(knight2.getName(), "Забег на время"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        knight1.startTrials(executor);
        knight2.startTrials(executor);

        executor.shutdown();
    }
}
