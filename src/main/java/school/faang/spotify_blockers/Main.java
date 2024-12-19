package school.faang.spotify_blockers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = Arrays.asList(
                new Thread(player::play),
                new Thread(player::stop),
                new Thread(player::skip),
                new Thread(player::previous)
        );
        threads.forEach(Thread::start);
    }
}
