package faang.school.godbless.paralelism.weasley_family;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "Washing windows",
                "Cleaning Furniture",
                "Washing dishes",
                "Sweeping the floor",
                "Cocking",
                "Fixing broken things"
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
    }
}
