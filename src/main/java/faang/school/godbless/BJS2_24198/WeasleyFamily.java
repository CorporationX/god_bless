package faang.school.godbless.BJS2_24198;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Vacuum the living room", "Wash the dishes", "Go grocery shopping", "Water the plants"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();
    }
}
