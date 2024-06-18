package faang.school.godbless.BJS210926;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Trial trialVizerisOne = new Trial("Vizeris", "Анжуманя");
        Trial trialVizerisTwo = new Trial("Vizeris", "Пресс качат");
        Trial trialHallOne = new Trial("Hall", "Бегит");
        Trial trialHallTwo = new Trial("Hall", "Турник");

        Knight  vizeris = new Knight("Vizeris");
        vizeris.addTrial(trialVizerisOne);
        vizeris.addTrial(trialVizerisTwo);

        Knight  hall = new Knight("Hall");
        vizeris.addTrial(trialHallOne);
        vizeris.addTrial(trialHallTwo);

        ExecutorService poll = Executors.newFixedThreadPool(2);

        vizeris.startTrials(poll);
        hall.startTrials(poll);

        poll.shutdown();
    }
}
