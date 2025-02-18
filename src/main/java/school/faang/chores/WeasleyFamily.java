package school.faang.chores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Wash dishes", "Clean the house", "Water plants"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String string : chores) {
            Chore chore = new Chore(string);
            executor.execute(chore);
            chore.run();
        }
        executor.shutdownNow();
        System.out.println("The work is done");
    }
}
