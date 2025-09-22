package school.faang.module3.weasley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        String[] chores = weasleyFamily.getChores();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
    }
}
