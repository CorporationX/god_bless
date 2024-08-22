package faang.school.godbless.BJS2_24207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = new ArrayList<>(Arrays.asList(
                "Clean the house",
                "Wash the dishes",
                "Do the laundry",
                "Cook dinner"
        ));

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(var chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
    }
}
