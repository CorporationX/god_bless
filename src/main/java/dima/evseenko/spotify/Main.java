package dima.evseenko.spotify;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(player::play));
        threads.add(new Thread(player::pause));
        threads.add(new Thread(player::skip));
        threads.add(new Thread(player::previous));

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(player.isPlaying());
    }
}
