package school.BJS2_35761;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        final int SIZE_OF_THREADS = 2;

        Knight knight_1 = new Knight("Рома");
        Knight knight_2 = new Knight("Костя");
        Trial trial_1 = new Trial("Рома", "Поедание сосисок");
        Trial trial_2 = new Trial("Рома", "Прыжки через скакалку");
        Trial trial_3 = new Trial("Костя", "Бег на 5 км");
        Trial trial_4 = new Trial("Костя", "Прыжки в воду");
        knight_1.addTrial(trial_1);
        knight_1.addTrial(trial_2);
        knight_2.addTrial(trial_3);
        knight_2.addTrial(trial_4);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(SIZE_OF_THREADS);

        fixedThreadPool.execute(knight_1::startTrial);
        fixedThreadPool.execute(knight_2::startTrial);

        fixedThreadPool.shutdown();
    }
}
