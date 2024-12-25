package school.faang.bjs49318;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Main {
    public static final int TEST_ACTIONS_NUMBER = 10;
    public static final long TIME_BETWEEN_ACTIONS = 5000;
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        List<String> songs = List.of("Lose yourself", "Godzilla", "Love way you lie", "Diamonds");
        Player player = new Player(songs);
        List<Thread> threads = new ArrayList<>();

        Thread mainPlayer = new Thread(() -> {
            try {
                player.playSong();
            } catch (InterruptedException e) {
                log.error("Error while playing {}", e.getMessage());
            }
        });

        for (int i = 0; i < TEST_ACTIONS_NUMBER; i++) {
            threads.add(new Thread(getRandomTestAction(player)));
        }

        mainPlayer.start();
        threads.forEach((thread) -> {
            try {
                Thread.sleep(TIME_BETWEEN_ACTIONS);
                thread.start();
            } catch (InterruptedException e) {
                log.error("Error while creating threads for test actions {}", e.getMessage());
            }
        });
    }

    public static Runnable getRandomTestAction(Player player) {
        int actionType = RANDOM.nextInt(6);
        if (actionType == 1) {
            return player::play;
        } else if (actionType == 2 || actionType == 3) {
            return player::pause;
        } else if (actionType == 4) {
            return () -> {
                player.previous();
                player.play();
            };
        } else {
            return () -> {
                player.skip();
                player.play();
            };
        }
    }
}
