package faang.school.godbless.theTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        Knight john = new Knight("John");
        Knight jaime = new Knight("Jaime");
        john.addTrail(new Trial(john.getName(), "Horse riding"));
        jaime.addTrail(new Trial(jaime.getName(), "Horse riding"));
        john.addTrail(new Trial(john.getName(), "Swords fight"));
        jaime.addTrail(new Trial(jaime.getName(), "Swords fight"));
        startTrials(john);
        startTrials(jaime);
        executor.shutdown();
    }
    private static void startTrials (Knight knight){
        for (Trial trial : knight.getTrials()) {
            executor.submit(trial);
        }
    }
}
