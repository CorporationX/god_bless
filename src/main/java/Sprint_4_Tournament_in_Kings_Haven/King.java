package Sprint_4_Tournament_in_Kings_Haven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Vlad");
        Knight knight2 = new Knight("Vitaliy");

        knight1.addTrial(new Trial(knight1.getName(), "Solve out the problem with enemies from another kingdom", 4000L));
        knight1.addTrial(new Trial(knight1.getName(), "Forge the armor", 6000L));
        knight2.addTrial(new Trial(knight2.getName(), "Choose the fastest horse from the stable", 2000L));
        knight2.addTrial(new Trial(knight2.getName(), "Find the golden sword", 30000L));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(knight1);
        executor.submit(knight2);

        executor.shutdown();

    }
}
