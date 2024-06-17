package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"мойка", "стирка", "чистка", "охота", "крепкая"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore:chores) {
            executorService.submit(() -> new Chore(chore).run());
        }
        executorService.shutdown();
    }
}
