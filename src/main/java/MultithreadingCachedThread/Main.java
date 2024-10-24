package MultithreadingCachedThread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WesleyFamily wesleyFamily = new WesleyFamily(List.of(
                "Clean up the room",
                "Do the laundry",
                "Sweep the floor",
                "Making the bed",
                "Loading the dishwasher"
        ));

        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : wesleyFamily.getChores()) {
            Chore ch = new Chore(chore);
            executor.execute(ch);
        }
        executor.shutdown();
    }
}
