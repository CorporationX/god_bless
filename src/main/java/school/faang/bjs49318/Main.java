package school.faang.bjs49318;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<String> songs = List.of("Знаешь ли ты", "Котик", "Love the way you lie", "Diamonds", "Lonely");
        Player player = new Player(songs);
        List<Thread> threads = new ArrayList<>();

        Thread mainPlayer = new Thread(() -> {
            try {
                player.playSong();
            } catch (InterruptedException e) {
                log.error("Error while playing {}", e.getMessage());
            }
        });

        for (int i = 0; i < 10; i++) {
            Thread thread;
            int actionType = random.nextInt(5);

            if (actionType == 1) {
                thread = new Thread(player::play);
            } else if (actionType == 2) {
                if (!player.isPlaying()) {
                    thread = new Thread(player::play);
                } else {
                    thread = new Thread(player::pause);
                }
            } else if (actionType == 3) {
                thread = new Thread(player::previous);
            } else {
                thread = new Thread(player::skip);
            }

            threads.add(thread);
        }

        mainPlayer.start();
        threads.forEach((thread) -> {
            try {
                Thread.sleep(5000);
                thread.start();
            } catch (InterruptedException e) {
                log.error("this never happen");
            }
        });
    }
}
