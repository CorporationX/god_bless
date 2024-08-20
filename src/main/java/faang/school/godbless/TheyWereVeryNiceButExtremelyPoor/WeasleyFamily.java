package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[] {"eat", "walk", "jump", "hide", "run"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();

    }
}
