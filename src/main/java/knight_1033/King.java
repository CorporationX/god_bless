package knight_1033;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {

        Knight knight1 = new Knight("Knight_Alfa");
        Knight knight2 = new Knight("Knight_Beta");
        knight1.addTrial(new Trial(knight1.getName(), "trial_1_1"));
        knight1.addTrial(new Trial(knight1.getName(), "trial_1_2"));
        knight2.addTrial(new Trial(knight2.getName(), "trial_2_1"));
        knight2.addTrial(new Trial(knight2.getName(), "trial_2_2"));

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> knight1.startTrials());
        service.submit(() -> knight2.startTrials());
        service.shutdown();
    }
}