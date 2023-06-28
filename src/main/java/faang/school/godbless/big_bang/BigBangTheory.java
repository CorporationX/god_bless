package faang.school.godbless.big_bang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task read = new Task("Sheldon", "read a book");
        Task cook = new Task("Leonard", "cook dinner");
        Task clean = new Task("Howard", "clean the apartment");
        Task shopping = new Task("Rajesh", "go shopping");

        executorService.submit(read);
        executorService.submit(cook);
        executorService.submit(clean);
        executorService.submit(shopping);
        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tasks completed");
    }
}
