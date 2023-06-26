package Weasley_Family;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash the dishes" +
                "wash the floors" + "wipe the dust" +
                "put things in their places" +
                "cook dinner" + "laundry" + "water the flowers" };

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore: chores){
            executor.execute(new Chore(chore));
        }

        executor.shutdown();

    }
}
