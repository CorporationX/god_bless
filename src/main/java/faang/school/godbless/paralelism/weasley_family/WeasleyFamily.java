package faang.school.godbless.paralelism.weasley_family;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = {
                new Chore("Washing windows"),
                new Chore("Cleaning Furniture"),
                new Chore("Washing dishes"),
                new Chore("Sweeping the floor"),
                new Chore("Cocking"),
                new Chore("Fixing broken things")
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        for(Chore chore : chores){
            executor.submit(chore);
        }
        executor.shutdown();
    }
}
