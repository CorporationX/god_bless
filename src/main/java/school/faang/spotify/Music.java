package school.faang.spotify;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = List.of(new Thread(player::play), new Thread(player::previous),
                new Thread(player::skip), new Thread(player::pause));
        threads.forEach(Thread::start);
    }
}
