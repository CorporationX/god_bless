package school.faang.sprint_3.task_43563;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        Player player = new Player();
        List<Runnable> actions = new ArrayList<>(List.of(
                player::play, player::pause, player::skip, player::previous));
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        actions.forEach(executor::execute);

        executor.shutdown();
    }
}