package faang.school.godbless.they_were_very_nice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash", "cleaning", "dishwasher", "cooking"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executor.submit(chore);
        }
        executor.shutdown();
    }
}
