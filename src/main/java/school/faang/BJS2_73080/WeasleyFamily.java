package school.faang.BJS2_73080;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] choreNames = {
                "Wash the dishes",
                "Iron the clothes",
                "Prepare dinner",
                "Clean the house",
                "Wash the car",
                "Pick up the groceries",
                "Do the laundry"
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String choreName : choreNames) {
            executor.submit(() -> new Chore(choreName), choreName);
            System.out.println("Assigned " + choreName + " to " + Thread.currentThread().getName());
        }

        executor.shutdown();
    }
}