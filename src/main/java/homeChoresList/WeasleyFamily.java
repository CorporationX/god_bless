package homeChoresList;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("Cook food", "Plan and Shop",
                "Wash things", "Cleaning", "Taking out the trash", "Do minor repairs", "Plan your budget");

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < chores.size(); i++) {
            int j = i;
            executor.submit(() -> new Chore(chores.get(j)).run());
        }

        executor.shutdown();

    }
}
