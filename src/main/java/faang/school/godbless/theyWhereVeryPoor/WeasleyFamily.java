package faang.school.godbless.theyWhereVeryPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String [] chores = {"clean dishes","wash clothes","clean floor", "cook"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for(String s: chores){
            Chore chore = new Chore(s);
            executor.submit(chore);
        }
        executor.shutdown();
    }
}
