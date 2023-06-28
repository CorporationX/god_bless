package Sprint_4_Task9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight vlad = new Knight("Vlad");
        Knight inna = new Knight("Inna");
        vlad.addTrial(new Trial("Vlad", "test of courage"));
        vlad.addTrial(new Trial("Vlad", "strength test"));
        inna.addTrial(new Trial("Inna", "test of courage"));
        inna.addTrial(new Trial("Inna", "strength test"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Trial thread : vlad.startTrials()) {
            executor.submit(thread);
        }
        for (Trial thread : inna.startTrials()) {
            executor.submit(thread);
        }
        executor.shutdown();
    }
}
