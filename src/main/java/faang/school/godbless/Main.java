package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String[] chores = {
                "Wash dishes",
                "Clean the house",
                "Mow the lawn",
                "Do laundry"
        };
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executorService.execute(task);
        }
        executorService.shutdown();

    }
}
