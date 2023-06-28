package faang.school.godbless.parallelismAndThread.theyWereVeryNice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final int NUMBER_OF_CHORES = 5;

    public static void main(String[] args) {
        String[] chores = new String[NUMBER_OF_CHORES];
        for (int i = 0; i < chores.length; i++) {
            chores[i] = "chore №" + (i + 1);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String string : chores) {
            executorService.execute(new Chore(string));
        }

        executorService.shutdown();
    }
}
