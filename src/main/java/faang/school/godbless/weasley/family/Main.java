package faang.school.godbless.weasley.family;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String[] chores = {"wash dishes", "clean the room", "take out garbage"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            Chore choreThreads = new Chore(chore);
            executorService.submit(choreThreads);
        }
        executorService.shutdown();
    }
}
