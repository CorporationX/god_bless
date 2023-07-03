package faang.school.godbless.spring_4.kings_landing_tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight = new Knight("Ronald");
        knight.addTrial(new Trial("Dima", "battle on ice swords"));
        knight.addTrial(new Trial("Viti", "jumping from a trampoline in length"));
        Knight knight1 = new Knight("Orex");
        knight1.addTrial(new Trial("Pavel", "ride a bike at speed"));
        knight1.addTrial(new Trial("Valia", "tug of war"));

        ExecutorService pool = Executors.newFixedThreadPool(2);

        knight.startTrials(pool);
        knight1.startTrials(pool);

        pool.shutdown();
    }
}
