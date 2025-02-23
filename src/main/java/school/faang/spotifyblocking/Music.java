package school.faang.spotifyblocking;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private static final Player player = new Player();

    private static final Thread threadPlay = new Thread(player::play);
    private static final Thread threadPause = new Thread(player::pause);
    private static final Thread threadSkip = new Thread(player::skip);
    private static final Thread threadPrevious = new Thread(player::previous);

    private static final List<Thread> threads =
            new ArrayList<>(List.of(threadPlay, threadPause, threadSkip, threadPrevious));

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}