package homeChoresList;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("Cook food", "Plan and Shop",
                "Wash things", "Cleaning", "Taking out the trash",
                "Do minor repairs", "Plan your budget");

        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(chore -> executor.execute(() -> new Chore(chore).run()));
        executor.shutdown();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All chores is completed");

    }
}
