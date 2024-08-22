package faang.school.godbless.sprint3.spotify;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Music {
    private static Player player;

    private static void sleepThreadAndDoActions(Consumer<Player> consumer) {
        IntStream.rangeClosed(1, 5).forEach(cur -> {
            try {
                Thread.sleep(new Random().nextInt(1, 10) * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consumer.accept(player);
        });
    }

    public static void main(String[] args) {
        List<String> songs = List.of("Song 1", "Song 2", "Song 3", "Song 4", "Song 5",
                "Song 6", "Song 7", "Song 8", "Song 9", "Song 10");
        player = new Player(songs, new Object());
        Thread playThread = new Thread(() -> sleepThreadAndDoActions(Player::play));
        Thread pauseThread = new Thread(() -> sleepThreadAndDoActions(Player::pause));
        Thread skipThread = new Thread(() -> sleepThreadAndDoActions(Player::skip));
        Thread previousThread = new Thread(() -> sleepThreadAndDoActions(Player::previous));

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
