package school.faang.housework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"fix the window ", " sweep the floor",
                "change the light bulb", "clean", "clean the room"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String task : chores) {
            Chore chore = new Chore(task);
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}
