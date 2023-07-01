package faang.school.godbless.Spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {

    private static Player player = new Player();

    public static void main(String[] args) {

        Thread playThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        List<Thread> threads = new ArrayList<>();
        threads.add(playThread);
        threads.add(pauseThread);
        threads.add(skipThread);
        threads.add(previousThread);

        threads.stream().forEach(thread -> thread.start());
        threads.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
