package school.BJS2_35761;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        final int SIZE_OF_THREADS = 2;

        Knight knight_1 = new Knight("Рома");
        Knight knight_2 = new Knight("Костя");
        Trial trial_1 = new Trial("Поедание сосисок");
        Trial trial_2 = new Trial("Прыжки через скакалку");
        Trial trial_3 = new Trial("Бег на 5 км");
        Trial trial_4 = new Trial("Прыжки в воду");
        knight_1.addTrial("Рома", trial_1);
        knight_1.addTrial("Рома", trial_2);
        knight_2.addTrial("Костя", trial_3);
        knight_2.addTrial("Костя", trial_4);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(SIZE_OF_THREADS);

        fixedThreadPool.execute(knight_1::startTrial);
        fixedThreadPool.execute(knight_2::startTrial);

        fixedThreadPool.shutdown();
    }
}
