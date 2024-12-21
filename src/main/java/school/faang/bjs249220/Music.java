package school.faang.bjs249220;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(false);
        final List<Thread> threads = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );

        threads.forEach(Thread::start);;
    }
}
