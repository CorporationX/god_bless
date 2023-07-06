package faang.school.godbless.good_n_poor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {

        List<String> chores = new ArrayList<>();
        chores.add("Land a position FAANG");
        chores.add("Make billions");
        chores.add("Complete this task");
        chores.add("Learn Java (optionally)");

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (var task : chores) {
            Chore chore = new Chore(task);
            executorService.submit(chore);
        }

        executorService.shutdown();
    }
}
