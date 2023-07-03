package faang.school.godbless.KingTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Knight arthur = new Knight("Arthur");
        Knight bahrateon = new Knight("Bahrateon");
        arthur.addTrial(new Trial("Battle 1",arthur.getName()));
        arthur.addTrial(new Trial("Battle 2",arthur.getName()));
        bahrateon.addTrial(new Trial("Battle 3",bahrateon.getName()));
        bahrateon.addTrial(new Trial("Battle 4",bahrateon.getName()));
        for (Thread thread: arthur.startTrials()){
            service.execute(thread);
        }
        for (Thread thread: bahrateon.startTrials()){
            service.execute(thread);
        }
        service.shutdown();
    }
}
