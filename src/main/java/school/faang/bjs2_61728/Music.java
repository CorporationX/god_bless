package school.faang.bjs2_61728;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(() -> player.play()));
        threads.add(new Thread(() -> player.pause()));
        threads.add(new Thread(() -> {
            try {
                player.skip();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        threads.add(new Thread(() -> {
            try {
                player.previous();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All actions are completed.");
    }
}
