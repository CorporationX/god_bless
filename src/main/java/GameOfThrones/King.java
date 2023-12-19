package GameOfThrones;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight jorah = new Knight("Jorah");
        Knight jeremy = new Knight("Jeremy");

        jorah.addTrial(new Trial(jorah.getName(), "Jumping rope"));
        jorah.addTrial(new Trial(jorah.getName(), "Lying on the bed"));
        jeremy.addTrial(new Trial(jeremy.getName(), "Jumping rope"));
        jeremy.addTrial(new Trial(jeremy.getName(), "Lying on the bed"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        jorah.startTrials(executorService);
        jeremy.startTrials(executorService);
        executorService.shutdown();;
    }
}
