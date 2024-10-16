package bjs2_35746;

import java.util.List;

public class Music {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        List<Thread> threads = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );

        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        System.out.println(player.isPlaying());
    }
}
