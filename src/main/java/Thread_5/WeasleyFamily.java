package Thread_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Task1", "Task2", "Task3", "Task4"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
        System.out.println("All tasks complete");
    }
}
