package faang.school.godbless.they_were_very_nice_but_extremely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{
                "Wipe the floor",
                "Wash the dishes",
                "Wipe off the dust",
                "Clean the room",
                "Wash the clothes"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
