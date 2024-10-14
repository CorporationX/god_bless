package school.faang.chores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = new ArrayList<>(List.of(
                "Wash dishes",
                "Drink beer",
                "Sweep floor",
                "Cook dinner",
                "Clean fridge",
                "Read book"));

        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
    }
}
