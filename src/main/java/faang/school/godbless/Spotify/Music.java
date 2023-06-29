package faang.school.godbless.Spotify;

import java.util.Arrays;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        var threads = Arrays.asList(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );
        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Done");
    }
}
