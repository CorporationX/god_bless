package faang.school.godbless.mt.spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        int playThreadCount = 200;
        int pauseThreadCount = 200;
        int skipThreadCount = 200;
        int previousThreadCount = 200;

        List<Thread> threads = new ArrayList<>();

        final Player player = new Player();

        for (int i = 0; i < playThreadCount; i++) {
            threads.add(new Thread(player::play));
        }
        for (int i = 0; i < pauseThreadCount; i++) {
            threads.add(new Thread(player::pause));
        }
        for (int i = 0; i < skipThreadCount; i++) {
            threads.add(new Thread(player::skip));
        }
        for (int i = 0; i < previousThreadCount; i++) {
            threads.add(new Thread(player::previous));
        }

        threads.forEach(Thread::start);
        for(var t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf("Current track number: %s%n", player.getTrackNumber());
        System.out.printf("Current status: %s%n", player.isPlaying());
    }
}
