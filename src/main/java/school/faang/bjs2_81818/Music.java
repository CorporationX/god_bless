package school.faang.bjs2_81818;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Map<String, Runnable> actions = Map.of(
                "play", player::play,
                "pause", player::pause,
                "skip", player::skip,
                "previous", player::previous
        );

        runUserThreads(actions);
    }

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    private static void runUserThreads(Map<String, Runnable> actions) {
        Thread user1 = new Thread(() -> {
            log.info("User1: play");
            actions.get("play").run();
        });

        Thread user2 = new Thread(() -> {
            log.info("User2: pause");
            actions.get("pause").run();
        });

        Thread user3 = new Thread(() -> {
            log.info("User3: skip");
            actions.get("skip").run();
        });

        Thread user4 = new Thread(() -> {
            log.info("User4: previous");
            actions.get("previous").run();
        });

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}