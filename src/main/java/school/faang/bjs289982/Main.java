package school.faang.bjs289982;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        WeasleyFamily weasleyFamily = new WeasleyFamily();

        weasleyFamily.getChoreList().forEach(executorService::submit);

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            System.out.println("Awating working threads");
        }
        System.out.println("All chores are done!");
    }
}
