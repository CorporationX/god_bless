package Wisley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[10];
        for (int i = 0; i < chores.length; i++) {
            chores[i] = "Chore Number " + i;
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String s : chores) {
            Chore chore = new Chore(s);
            executorService.execute(chore);
        }

        executorService.shutdown();
    }
}
