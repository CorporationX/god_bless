package faang.school.godbless.spotifyBlocking;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = List.of(new Thread(player::play), new Thread(player::pause),
                                        new Thread(player::skip), new Thread(player::stop));
        threads.forEach(Thread::start);
    }
}
