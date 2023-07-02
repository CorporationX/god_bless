package faang.school.godbless.threads.extremely_poor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = new ArrayList<>(List.of("Cleaning", "Shopping", "Playing", "Cooking", "Sleeping"));
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < chores.size(); i++) {
            executorService.execute(new Chore(chores.get(i)));
        }
        executorService.shutdown();
    }
}
