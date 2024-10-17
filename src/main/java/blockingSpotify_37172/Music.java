package blockingSpotify_37172;

import java.util.ArrayList;
import java.util.List;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> threads = new ArrayList<>(List.of(
                new Thread(player::play),
                new Thread(player::play),
                new Thread(player::stop),
                new Thread(player::stop),
                new Thread(player::play),
                new Thread(player::skip),
                new Thread(player::skip),
                new Thread(player::previous),
                new Thread(player::previous)
        ));
        threads.forEach(Thread::start);
    }
}
