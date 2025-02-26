package BJS261871;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>(List.of(new Thread(() -> player.play()),
                new Thread(() -> player.pause()),
                new Thread(() -> player.skip()),
                new Thread(() -> player.previous())));
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

    }
}
