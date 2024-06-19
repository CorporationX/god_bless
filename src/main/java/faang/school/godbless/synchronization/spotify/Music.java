package faang.school.godbless.synchronization.spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {

    public static void main(String[] args) {

        Player player = new Player();

        List<Thread> threads = new ArrayList<>();

        Thread playThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        threads.add(playThread);
        threads.add(pauseThread);
        threads.add(skipThread);
        threads.add(previousThread);

        threads.forEach(Thread::start);
    }
}
