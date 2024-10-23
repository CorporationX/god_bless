package school.faang.bjs2_37367;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadExecutor {
    private static final int THREAD_QUANTITY = 5;

    private final Player player;
    private final List<User> users;

    public ThreadExecutor(Player player, List<User> users) {
        this.player = player;
        this.users = users;
    }

    public void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_QUANTITY);

        for (int i = 0; i <= users.size() - 1; i++) {
            log.info(String.format("User %s used player", users.get(i).getNickname()));

            executor.submit(() -> {
                player.play();
                player.pause();
                player.skip();
                player.previous();
            });
        }
        executor.shutdown();
    }
}
