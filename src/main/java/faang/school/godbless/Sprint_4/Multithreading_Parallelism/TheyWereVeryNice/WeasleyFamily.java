package faang.school.godbless.Sprint_4.Multithreading_Parallelism.TheyWereVeryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = new ArrayList<>();
        ExecutorService executor = Executors.newCachedThreadPool();

        chores.add("Wash the dishes");
        chores.add("Dust the furniture");
        chores.add("Clean the house");

        for(String chore : chores)  {
            Chore cur = new Chore(chore);
            executor.submit(cur);
        }

        executor.shutdown();
    }
}
