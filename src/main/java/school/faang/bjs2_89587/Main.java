package school.faang.bjs2_89587;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        String[] chores = weasleyFamily.getChores();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
    }
}
