package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {

        System.out.println("Hello Almas!");

        String[] tasks = {
                "clean room 1",
                "clean room 2",
                "clean room 3",
                "clean room 4",
                "clean room 5"
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : tasks) {
            Chore chore = new Chore(task);
            executor.submit(chore);
        }
        executor.shutdown();
    }
}