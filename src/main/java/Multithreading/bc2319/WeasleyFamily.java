package Multithreading.bc2319;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        final int CHORESCOUNT = 10;
        Chore[] chores = new Chore[CHORESCOUNT];
        for (int i = 0; i < chores.length; i++) {
            chores[i] = new Chore("chore" + (i + 1));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}
