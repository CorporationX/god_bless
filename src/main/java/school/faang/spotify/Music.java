package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Music {

    public static void main(String[] args) {

        Player player = new Player();
        Thread[] threads = {new Thread(player::play), new Thread(player::pause),
                new Thread(player::previous), new Thread(player::skip)};

        Arrays.stream(threads).forEach(Thread::start);

        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Caught exception: {}", e.getMessage());
            }
        });
    }
}
