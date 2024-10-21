package school.faang.spotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Runnable> playerActions = new ArrayList<>();
        playerActions.add(player::play);
        playerActions.add(player::pause);
        playerActions.add(player::previous);
        playerActions.add(player::skip);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Runnable action : playerActions) {
            executor.execute(action);
        }
        executor.shutdown();
    }
}
