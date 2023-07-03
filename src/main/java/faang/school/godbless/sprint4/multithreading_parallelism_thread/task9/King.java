package faang.school.godbless.sprint4.multithreading_parallelism_thread.task9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        Knight knight1 = new Knight("King");
        Trial trial1 = new Trial(knight1.getName(), "Trial1");
        Trial trial2 = new Trial(knight1.getName(), "Trial2");
        Trial trial5 = new Trial(knight1.getName(), "Trial5");
        knight1.addTrial(trial1);
        knight1.addTrial(trial2);
        knight1.addTrial(trial5);
        Knight knight2 = new Knight("Queen");
        Trial trial3 = new Trial(knight2.getName(), "Trial1");
        Trial trial4 = new Trial(knight2.getName(), "Trial2");
        Trial trial6 = new Trial(knight2.getName(), "Trial6");
        knight2.addTrial(trial3);
        knight2.addTrial(trial4);
        knight2.addTrial(trial6);

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (Thread trial : knight1.startTrials()) {
            service.submit(trial);
        }
        for (Thread trial : knight2.startTrials()) {
            service.submit(trial);
        }

        service.shutdown();
    }
}
