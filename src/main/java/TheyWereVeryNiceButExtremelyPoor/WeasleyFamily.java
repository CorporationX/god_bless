package TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"покормить собаку", "сходить в магазин", "заняться спортом", "прочитать книгу"};
        ExecutorService executors = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executors.execute(chore);
        }
        executors.shutdown();
        executors.awaitTermination(6, TimeUnit.SECONDS);
    }
}
