package school.faang.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread thread = new Thread(player::play);
        Thread thread1 = new Thread(player::pause);

        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(player.getIsPlaying());
    }
}
