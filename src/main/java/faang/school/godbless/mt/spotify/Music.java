package faang.school.godbless.mt.spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        int threadCount = 200;

        List<Thread> threads = new ArrayList<>();

        final Player player = new Player();

        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(player::play));
            threads.add(new Thread(player::pause));
            threads.add(new Thread(player::skip));
            threads.add(new Thread(player::previous));
        }

        threads.forEach(Thread::start);
        try {
            for (var thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Current track number: %s%n", player.getTrackNumber());
        System.out.printf("Current status: %s%n", player.isPlaying());
    }
}
