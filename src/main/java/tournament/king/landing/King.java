package tournament.king.landing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        Knight knight1 = new Knight("Андрей");
        knight1.addTrial(new Trial(knight1.getName(), "Trial 1"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial 2"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial 3"));

        Knight knight2 = new Knight("Пётр");
        knight2.addTrial(new Trial(knight2.getName(), "Trial 1"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial 2"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        knight1.startTrial(service);
        knight2.startTrial(service);

        service.shutdown();
    }
}
