package faang.school.godbless.weasley_family;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        List<String> chores = List.of("wash the dishes", "cook the food", "do the landry", "clean the floor");

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();
    }
}
