package school.faang.BJS2_37276_BlockingSpotify;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> threads = Arrays.asList(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );

        Collections.shuffle(threads);
        threads.forEach(Thread::start);
    }
}
