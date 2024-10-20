package MultithreadingCachedThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WesleyFamily {
    private static List<String> chores = new ArrayList<>();

    public static void main(String[] args) {
        chores.add("Clean up the room");
        chores.add("Do the laundry");
        chores.add("Sweep the floor");
        chores.add("Making the bed");
        chores.add("Loading the dishwasher");

        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            Chore ch = new Chore(chore);
            executor.execute(ch);
        }
        executor.shutdown();
    }
}
