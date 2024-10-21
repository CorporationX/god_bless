package school.faang.blockingspotify;

import java.util.Arrays;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> userActions = Arrays.asList(
                new Thread(() -> player.play(), "User 1"),
                new Thread(() -> player.pause(), "User 2"),
                new Thread(() -> player.skip(), "User 3"),
                new Thread(() -> player.previous(), "User 4"),
                new Thread(() -> player.play(), "User 5"),
                new Thread(() -> player.pause(), "User 6")
        );

        userActions.forEach(Thread::start);

        userActions.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(thread.getName() + " was interrupted.");
            }
        });

        System.out.println("All user actions have been processed.");
    }
}

