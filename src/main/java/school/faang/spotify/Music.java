package school.faang.spotify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Music {

    private static final Logger LOGGER = LoggerFactory.getLogger(Music.class);

    public static void main(String[] args) {

        Player player = new Player();
        Thread[] threads = {new Thread(player::play), new Thread(player::pause),
                new Thread(player::previous), new Thread(player::skip)};

        Arrays.stream(threads).forEach(Thread::start);

        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.error("Caught exception: {}", e.getMessage());
            }
        });
    }
}
