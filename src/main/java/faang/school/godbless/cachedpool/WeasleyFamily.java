package faang.school.godbless.cachedpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        Chore[] chores = new Chore[10];
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(String.format("Chore %d", i));
            chores[i] = chore;
        }
        for (Chore chore : chores) {
            executor.execute(chore);
        }
        executor.shutdown();
    }
}